package es.josemasaborido.dibujando;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;


public class AreaDibujo extends View {
    private float x, y;
    private int pincelSelecionado = 0;

    private Canvas canvasExterno;
    private Paint paint;
    private Path path;
    private Bitmap bitmap;

    public AreaDibujo(Context context) {
        super(context);
        x = 100;
        y = 100;
        this.path = new Path();
        this.paint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0,0, paint);
        canvasExterno.drawPath(path, paint);

    }

    public void pintaEstrella(float x, float y) {

        this.paint.setColor(Color.BLUE);
        this.paint.setStrokeWidth(5);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.path.moveTo(x, y);
        this.path.lineTo(x - 30, y + 80);
        this.path.lineTo(x - 120, y + 80);
        this.path.lineTo(x - 56, y + 124);
        this.path.lineTo(x - 80, y + 210);
        this.path.lineTo(x, y + 154);
        this.path.lineTo(x + 80, y + 210);
        this.path.lineTo(x + 56, y + 124);
        this.path.lineTo(x + 120, y + 80);
        this.path.lineTo(x + 30, y + 80);
        this.path.lineTo(x, y);
    }

    public void pintarCirculo(float x, float y, int color){
        this.paint.setColor(ContextCompat.getColor(getContext(), color));
        this.path.addCircle(x,y,20, Path.Direction.CCW);
    }

    public void pintarCara(float x, float y){
        Bitmap cara = BitmapFactory.decodeResource(getResources(), R.drawable.cara);
        canvasExterno.drawBitmap(cara, x, y, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                switch(pincelSelecionado){
                    case 1:
                        this.path.reset();
                        pintarCirculo(x,y, R.color.yellow);
                        break;
                    case 2:
                        this.path.reset();
                        pintarCirculo(x, y, R.color.red);
                        break;
                    case 3:
                        this.path.reset();
                        pintarCirculo(x, y, R.color.green);
                        break;
                    case 4:
                        this.path.reset();
                        pintaEstrella(x, y);
                        break;
                    case 5:
                        this.path.reset();
                        pintarCara(x, y);
                        break;
                }
        }
        invalidate();
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvasExterno = new Canvas(bitmap);
    }

    public void borrar(){
        canvasExterno.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public Canvas getCanvasExterno() {
        return canvasExterno;
    }

    public void setCanvasExterno(Canvas canvasExterno) {
        this.canvasExterno = canvasExterno;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getPincelSelecionado() {
        return pincelSelecionado;
    }

    public void setPincelSelecionado(int pincelSelecionado) {
        this.pincelSelecionado = pincelSelecionado;
    }
}
