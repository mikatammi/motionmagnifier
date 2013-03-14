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

public class ViewerActivity extends Activity
{
    Camera camera;
    SurfaceView surfaceView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        surfaceView = (SurfaceView) findViewById(R.id.surfaceview);

        camera = Camera.open(0);

    }
}
