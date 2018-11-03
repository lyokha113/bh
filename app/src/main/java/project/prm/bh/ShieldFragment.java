package project.prm.bh;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.FileNotFoundException;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class ShieldFragment extends Fragment {

    private View inputShield, deviceImage, qrscanner;
    private Uri selectedUriImage;

    public ShieldFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shield, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        inputShield = getActivity().findViewById(R.id.inputShield);
        inputShield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InputShieldActivity.class);
                startActivity(intent);
            }
        });

        deviceImage = getActivity().findViewById(R.id.deviceImage);
        deviceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, ConstantManagement.DEVICE_IMAGE_REULST);
            }
        });

        qrscanner = getActivity().findViewById(R.id.qrscanner);
        qrscanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScannerQRActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ConstantManagement.DEVICE_IMAGE_REULST && data != null) {
            try {
                selectedUriImage = data.getData();
                Bitmap myBitmap = decodeBitmapUri(getActivity(), selectedUriImage);
                BarcodeDetector detector = new BarcodeDetector.Builder(getActivity().getApplicationContext())
                        .setBarcodeFormats(Barcode.QR_CODE)
                        .build();
                Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
                SparseArray<Barcode> barsCode = detector.detect(frame);
                if (barsCode.size() > 0) {
                    Intent intent = new Intent(getActivity(), ShieldResultActivity.class);
                    startActivity(intent);
                } else {
                    showAlertDialog("QUÉT MÃ QR", "Không xác nhận được mã QR từ ảnh đã chọn", "ĐÓNG");
                }
            } catch (FileNotFoundException e) {
                Log.e("DEVICE IMAGE", e.getMessage());
                showAlertDialog("QUÉT MÃ QR", "Hệ thống có sữ cố", "ĐÓNG");
            }
        }
    }

    private Bitmap decodeBitmapUri(Context ctx, Uri uri) throws FileNotFoundException {
        int targetW = 600;
        int targetH = 600;
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(ctx.getContentResolver().openInputStream(uri), null, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;

        return BitmapFactory.decodeStream(ctx.getContentResolver()
                .openInputStream(uri), null, bmOptions);
    }

    private void showAlertDialog(String title, String msg, String btnPos) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(btnPos, null);
        builder.setIcon(R.drawable.ic_visibility_off_black_24dp);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}
