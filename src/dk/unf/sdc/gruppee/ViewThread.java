package dk.unf.sdc.gruppee;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import dk.unf.sdc.gruppee.GameActivity.DrawView;

public class ViewThread extends Thread{

	private DrawView mDrawView;
	private SurfaceHolder mHolder;
	private boolean mRun = false;
	
	
	public ViewThread(DrawView drawView){
		mDrawView = drawView;
		mHolder = mDrawView.getHolder();
		
	}

	public void setRunning (boolean run){
		mRun = run;
		
	}

	@Override
	public void run(){
		Canvas canvas = null;
		while (mRun){
			canvas = mHolder.lockCanvas();
			if (canvas != null)
				mDrawView.onDraw(canvas);
				mHolder.unlockCanvasAndPost(canvas);
		}
	}



}
