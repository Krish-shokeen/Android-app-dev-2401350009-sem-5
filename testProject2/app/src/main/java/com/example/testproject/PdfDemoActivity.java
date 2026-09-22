package com.example.testproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class PdfDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_demo);

        Button btnOpenPdf = findViewById(R.id.btnOpenPdf);
        btnOpenPdf.setOnClickListener(v -> openPdfFromAssets("CppNotes.pdf"));
    }

    private void openPdfFromAssets(String fileName) {
        try {
            // 1. Copy PDF from assets to internal storage (cache)
            InputStream inputStream = getAssets().open(fileName);
            File outFile = new File(getCacheDir(), fileName);
            OutputStream outputStream = new FileOutputStream(outFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            
            inputStream.close();
            outputStream.close();

            // 2. Open PDF using an Intent
            // Note: Modern Android versions (API 24+) require FileProvider instead of Uri.fromFile
            Uri uri = FileProvider.getUriForFile(this, getPackageName() + ".provider", outFile);
            
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "application/pdf");
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Unable to open PDF", Toast.LENGTH_SHORT).show();
        }
    }
}
