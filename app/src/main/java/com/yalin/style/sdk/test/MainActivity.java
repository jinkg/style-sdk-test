package com.yalin.style.sdk.test;

import android.Manifest.permission;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";
  private static final int STORE_PERMISSION = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    System.loadLibrary("gdx");
    setContentView(R.layout.activity_main);
  }

  public void setWallpaper(View view) {
    String[] storePermission = new String[]{permission.READ_EXTERNAL_STORAGE};
    if (ContextCompat.checkSelfPermission(this, permission.READ_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(this, storePermission, STORE_PERMISSION);
    } else {
      setWallpaper();
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == STORE_PERMISSION && grantResults.length == 1
        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
      setWallpaper();
    }
  }

  private void setWallpaper() {
    Intent intent = new Intent(
        WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
    intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
        new ComponentName(this, StyleWallpaperService.class));
    startActivity(intent);
  }
}
