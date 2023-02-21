package es.josemasaborido.dibujando;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;


public class AreaDibujo extends View {
    private boolean drawable;
    private int drawableId;
    private String color;
    private float x, y;

    private Canvas canvasExterno;
    private Paint paint;
    private Path path;
    private Bitmap bitmap;

    public AreaDibujo(Context context) {
        super(context);
        x = 100;
        y = 100;
        this.path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.paint = new Paint();
        this.paint.setColor(Color.BLUE);
        this.paint.setStrokeWidth(5);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        pintaEstrella(this.x, this.y);
        canvas.drawPath(this.path, this.paint);
        
    }

    private void pintaEstrella(float x, float y) {
        
        this.path.moveTo(x,y);
        this.path.lineTo(x - 100,y + 100);
        this.path.lineTo(x + 100,y + 100);
        this.path.lineTo(x,y);
        this.path.moveTo(x - 100,y + 33);
        this.path.lineTo(x + 100,y + 33);
        this.path.lineTo(x,y+133);
        this.path.lineTo(x-100,y + 33);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();


        return super.onTouchEvent(event);
    }

    public boolean isDrawable() {
        return drawable;
    }

    public void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
