package com.mrangle.hogomogo.Class;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.WindowManager;
import android.widget.ImageView;

public final class PhotoEditor {


    public static void setImage(ImageView image, Bitmap bitmap, Uri uri, Context context ) {

            WindowManager mWinMgr = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

            assert mWinMgr != null;
            int width = mWinMgr.getDefaultDisplay().getWidth();
            int height = mWinMgr.getDefaultDisplay().getWidth();

            int testHeight = bitmap.getHeight();
            int testWidth = bitmap.getWidth();

            // oblicza stosunek szerokosci do wysokosci
            double stosunek = testHeight / (double) testWidth;

            height = (int) (height * stosunek);

            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
            image.setImageBitmap(bitmap);
    }
}
