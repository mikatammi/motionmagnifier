/*
 * VieverActivity.java - Main activity for program
 *
 * Copyright 2013 Mika Tammi
 *
 * This file is part of MotionMagnifier.
 *
 * MotionMagnifier is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MotionMagnifier is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MotionMagnifier.  If not, see <http://www.gnu.org/licenses/>.
 */

package fi.ponr.motionmagnifier;

import android.app.Activity;
import android.os.Bundle;
import android.hardware.Camera;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.graphics.PixelFormat;

import java.io.IOException;

public class ViewerActivity extends Activity implements SurfaceHolder.Callback
{
    Camera camera;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    Button btn;

    public void surfaceChanged(SurfaceHolder holder,
            int format, int width, int height)
    {
    }

    public void surfaceCreated(SurfaceHolder holder)
    {
    }

    public void surfaceDestroyed(SurfaceHolder holder)
    {
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Get button from layout
        btn = (Button) findViewById(R.id.btnstart);

        // Get surface view from layout
        surfaceView = (SurfaceView) findViewById(R.id.surfaceview);

        // Set window pixel format
        getWindow().setFormat(PixelFormat.UNKNOWN);

        // Get surfaceholder from surfaceview
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        btn.setOnClickListener(
                new Button.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        camera = Camera.open(0);

                        Camera.Parameters param = camera.getParameters();
                        
                        /*
                        param.setPreviewFrameRate(20);
                        param.setPreviewSize(176, 144);
                        */

                        camera.setParameters(param);

                        try
                        {
                            camera.setPreviewDisplay(surfaceHolder);
                            camera.startPreview();
                        }
                        catch (IOException e)
                        {
                            setTitle("Could not set preview display");
                            e.printStackTrace();
                        }
                    }
                });
    }
}
