#!/bin/bash
adb uninstall fi.ponr.motionmagnifier &
ant debug &&
ant debug install &&
adb shell am start -a android.intent.action.MAIN -n fi.ponr.motionmagnifier/fi.ponr.motionmagnifier.ViewerActivity
