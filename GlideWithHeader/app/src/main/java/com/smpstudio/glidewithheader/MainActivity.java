package com.smpstudio.glidewithheader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnTaiAnh;
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        imageView = findViewById(R.id.demo_img);
        btnTaiAnh = findViewById(R.id.btnTaiAnh);

        final RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        requestOptions.override(1084, 8000);

        ArrayList<String> urlList = new ArrayList<>();

//        testString = ["https://cdn.lhmanga.com/Store/Manga/5e36becdde4bb_5e36bed090bc9.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bed0ef91d_5e36bed34adeb.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bed3e2752_5e36bed6baca8.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bed721a50_5e36bed99786c.jpg","https://cdn.lhmanga.com/Store/Manga/5e36beda3c2ee_5e36bedd4a088.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bedda180c_5e36bee0a5199.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bee14ab99_5e36bee4167c6.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bee4a54f2_5e36bee70628d.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bee7976a5_5e36beeaa504e.jpg","https://cdn.lhmanga.com/Store/Manga/5e36beeb05e06_5e36beedbee7c.jpg","https://cdn.lhmanga.com/Store/Manga/5e36beee1db94_5e36beef339e5.jpg","https://cdn.lhmanga.com/Store/Manga/5e36beefc1b4d_5e36bef1b4577.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bef216df8_5e36bef385574.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bef42352e_5e36bef66cdc7.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bef6bfc6b_5e36bef8d62c7.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bef9740d3_5e36befc2ac0c.jpg","https://cdn.lhmanga.com/Store/Manga/5e36befcb7dec_5e36befea4cff.jpg","https://cdn.lhmanga.com/Store/Manga/5e36beff01eed_5e36bf012ab4b.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf01bf769_5e36bf0437fbe.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf048a3bc_5e36bf06a6e62.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf0705400_5e36bf09523d4.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf09a3212_5e36bf0b57fc2.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf0ba9f4d_5e36bf0de1b27.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf0e788a8_5e36bf109cf21.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf1135dfa_5e36bf133d1d6.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf13d7b2a_5e36bf16a63ff.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf17043d3_5e36bf1996cd3.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf19e83ad_5e36bf1c47c3e.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf1cdaa13_5e36bf2137597.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf21cc7e4_5e36bf250a229.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf25a04f4_5e36bf27e9b64.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf2849149_5e36bf2a35972.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf2ac85aa_5e36bf2e4f10a.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf2edc539_5e36bf30f35d4.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf3158b89_5e36bf368bc73.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf3730b67_5e36bf3c0e5c9.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf3ca2e7b_5e36bf3ee7ebe.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf3f4bc55_5e36bf419253a.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf422ddff_5e36bf44a71a7.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf4510d66_5e36bf4720297.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf47777df_5e36bf4a2df66.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf4a80c4a_5e36bf4cbc4ab.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf4d61047_5e36bf4f9a49a.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf50489c3_5e36bf52247a1.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf52b6790_5e36bf55870fa.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf55da70e_5e36bf57cdb30.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf5832262_5e36bf5a887ea.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf5adf64c_5e36bf5d250d3.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf5dbbe75_5e36bf5fe2217.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf604c70a_5e36bf65363ca.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf65c355c_5e36bf67c4f93.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf682163e_5e36bf6a49685.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf6a9ce19_5e36bf6c77a1a.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf6ccad01_5e36bf6e84a63.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf6ed6194_5e36bf712e0cc.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf717fd0e_5e36bf73868dd.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf73dc68c_5e36bf75bace0.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf7617f49_5e36bf78b871f.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf791380f_5e36bf7ae5e61.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf7b4067c_5e36bf7d8bab0.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf7e25fc8_5e36bf7f84b42.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf80436a0_5e36bf820b03b.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf825e131_5e36bf83ce2e1.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf8430065_5e36bf864579c.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf869708e_5e36bf88a76d3.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf893f88b_5e36bf8c5239b.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf8cea872_5e36bf8f475f1.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf8f9f523_5e36bf9293b60.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf93323aa_5e36bf9786825.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf9822901_5e36bf9a049ed.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf9aa1980_5e36bf9cab43f.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bf9d45cfa_5e36bfa0cd728.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfa16a625_5e36bfa318e51.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfa371c84_5e36bfa58d033.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfa5e6867_5e36bfa9122e4.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfa9ab9f4_5e36bfab8564f.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfac29f10_5e36bfae7b533.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfaed737a_5e36bfb1c1754.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfb264873_5e36bfb442430.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfb4a35eb_5e36bfb7774b7.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfb7d168a_5e36bfb9bbf9d.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfba22724_5e36bfbbcd546.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfbc6e66d_5e36bfbe5829e.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfbef0226_5e36bfc39a500.jpg","https://cdn.lhmanga.com/Store/Manga/5e36bfc4017a8_5e36bfc7cc155.jpg"];

        JSONArray arrUrl = new JSONArray();
        urlList.add("https://cdn.lhmanga.com/Store/Manga/5e36becdde4bb_5e36bed090bc9.jpg");
        urlList.add("https://cdn.lhmanga.com/Store/Manga/5e36bed0ef91d_5e36bed34adeb.jpg");
        urlList.add("https://cdn.lhmanga.com/Store/Manga/5e36bed721a50_5e36bed99786c.jpg");

        btnTaiAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        STORAGE_PERMISSION_CODE);
                checkPermission(Manifest.permission.CAMERA,
                        CAMERA_PERMISSION_CODE);

                Glide.with(getApplicationContext())
                    .asBitmap()
                    .load("https://cdn.lhmanga.com/Store/Manga/5e36becdde4bb_5e36bed090bc9.jpg")
                        .apply(requestOptions)
                    .into(new CustomTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                            saveImage(resource);
                        }

                        @Override
                        public void onLoadCleared(@Nullable Drawable placeholder) {

                        }
                    });
            }
        });



    }

    private String saveImage(Bitmap image) {
        String savedImagePath = null;

        String imageFileName = "JPEG_" + "FILE_NAME" + ".jpg";
        File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                + "/ZZZ");
        boolean success = true;
        if (!storageDir.exists()) {
            success = storageDir.mkdirs();
        }
        if (success) {
            File imageFile = new File(storageDir, imageFileName);
            savedImagePath = imageFile.getAbsolutePath();
            try {
                OutputStream fOut = new FileOutputStream(imageFile);
                image.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                fOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Add the image to the system gallery
            galleryAddPic(savedImagePath);
            Toast.makeText(this, "IMAGE SAVED", Toast.LENGTH_LONG).show();
        }
        return savedImagePath;
    }

    private void galleryAddPic(String imagePath) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(imagePath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        sendBroadcast(mediaScanIntent);
    }

    // Function to check and request permission.
    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[] { permission },
                    requestCode);
        }
        else {
            Toast.makeText(MainActivity.this,
                    "Permission already granted",
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
