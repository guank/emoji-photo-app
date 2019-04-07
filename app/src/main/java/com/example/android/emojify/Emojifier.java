package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

class Emojifier {

    /**
     * Method for detecting faces in a bitmap.
     *
     * @param context The application context.
     * @param picture The picture in which to detect the faces.
     */
    static void detectFaces(Context context, Bitmap picture){

        /* Create face detector, disable tracking and enable classification */
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        /* Build the frame */
        Frame frame = new Frame.Builder().setBitmap(picture).build();

        /* Detect the faces */
        SparseArray<Face> faces = detector.detect(frame);

        /* Log the number of faces */
        Log.d("LOG", "detectFaces: # of faces = " + faces.size());

        /* If zero faces are detected, display a toast message */
        if(faces.size() == 0){
            Toast.makeText(context, R.string.no_faces_message, Toast.LENGTH_SHORT).show();
        }

        /* Release detector */
        detector.release();
    }
}
