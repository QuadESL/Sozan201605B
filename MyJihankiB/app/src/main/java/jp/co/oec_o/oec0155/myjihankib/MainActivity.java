package jp.co.oec_o.oec0155.myjihankib;

import android.content.ClipData;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class MainActivity extends AppCompatActivity implements View.OnDragListener {

    @BindView(R.id.okane10000)
    ImageView okane10000;
    @BindView(R.id.okane500)
    ImageView okane500;
    @BindView(R.id.okane100)
    ImageView okane100;
    @BindView(R.id.syasin1)
    ImageView syasin1;
    @BindView(R.id.kakaku1)
    TextView kakaku1;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.syasin2)
    ImageView syasin2;
    @BindView(R.id.kakaku2)
    TextView kakaku2;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.syasin3)
    ImageView syasin3;
    @BindView(R.id.kakaku3)
    TextView kakaku3;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.goukeihyouji)
    TextView goukeihyouji;
    @BindView(R.id.toridasiguchi)
    ImageView toridasiguchi;
    @BindView(R.id.tounyuuguchi)
    ImageView tounyuuguchi;
    @BindView(R.id.oturihyouji)
    TextView oturihyouji;

    //投入金額を入れる変数
    int tounyuukinngaku;
    //合計金額を入れる変数
    int goukeikingaku;
    //おつりを入れる変数
    int oturikingaku;
    //商品１の価格を入れる変数
    int kakaku1kingaku;
    //商品2の価格を入れる変数
    int kakaku2kingaku;
    //商品3の価格を入れる変数
    int kakaku3kingaku;
    //お金を入れた時の音
    MediaPlayer sound1;
    //商品が出るときの音
    MediaPlayer sound2;
    @BindView(R.id.goukeihyouji1)
    TextView goukeihyouji1;
    @BindView(R.id.toridasiguchi1)
    TextView toridasiguchi1;
    @BindView(R.id.tounyuuguchi1)
    TextView tounyuuguchi1;
    @BindView(R.id.oturihyouji1)
    TextView oturihyouji1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tounyuuguchi.setOnDragListener(this);
        syokiSyori();
    }

    private void syokiSyori() {
        buttonAllOff();
        kakaku1kingaku = Integer.parseInt(kakaku1.getText().toString());
        kakaku2kingaku = Integer.parseInt(kakaku2.getText().toString());
        kakaku3kingaku = Integer.parseInt(kakaku3.getText().toString());
        sound1 = MediaPlayer.create(this, R.raw.hyun1);
        sound2 = MediaPlayer.create(this, R.raw.touch1);
    }

    private void buttonAllOff() {
        button1.setEnabled(false);
        button1.setBackgroundColor(Color.GRAY);
        button2.setEnabled(false);
        button2.setBackgroundColor(Color.GRAY);
        button3.setEnabled(false);
        button3.setBackgroundColor(Color.GRAY);
    }

    @OnTouch(R.id.okane10000)
    public boolean touchokane10000(ImageView img) {
        ClipData clipData = ClipData.newPlainText("okane", "10000");
        img.startDrag(clipData, new View.DragShadowBuilder(img), (Object) img, 0);
        return true;
    }

    @OnTouch(R.id.okane100)
    public boolean touchokane100(ImageView img) {
        ClipData clipData = ClipData.newPlainText("okane", "100");
        img.startDrag(clipData, new View.DragShadowBuilder(img), (Object) img, 0);
        return true;
    }

    @OnTouch(R.id.okane500)
    public boolean touchokane500(ImageView img) {
        ClipData clipData = ClipData.newPlainText("okane", "500");
        img.startDrag(clipData, new View.DragShadowBuilder(img), (Object) img, 0);
        return true;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        // 硬貨をドロップした時の処理
        // ドロップした時
        if (event.getAction() == DragEvent.ACTION_DROP) {
            // ドロップした先が投入口だったら
            if (v == tounyuuguchi) {
                // クリップデータを取り出して、投入金額変数に数字に変換してセットする
                ClipData clipData = event.getClipData();
                ClipData.Item item = clipData.getItemAt(0);
                tounyuukinngaku = Integer.parseInt((String) item.getText());
                tonyuSyori();
            }
            sound1.start();
        }
        return true;
    }

    private void tonyuSyori() {
        goukeikingaku = goukeikingaku + tounyuukinngaku;
        goukeihyouji.setText(String.valueOf(goukeikingaku));
        if (goukeikingaku >= kakaku1kingaku) {
            button1On();
        }
        if (goukeikingaku >= kakaku2kingaku) {
            button2On();
        }
        if (goukeikingaku >= kakaku3kingaku) {
            button3On();
        }
    }


    private void button1On() {
        button1.setEnabled(true);
        button1.setBackgroundColor(Color.MAGENTA);
    }

    private void button2On() {
        button2.setEnabled(true);
        button2.setBackgroundColor(Color.MAGENTA);
    }

    private void button3On() {
        button3.setEnabled(true);
        button3.setBackgroundColor(Color.MAGENTA);

    }

    @OnClick(R.id.button1)
    public void onClick1() {
        oturikingaku = goukeikingaku - kakaku1kingaku;
        toridasiguchi.setImageDrawable(syasin1.getDrawable());
        oturihyouji.setText(String.valueOf(oturikingaku));
        buttonAllOff();
        sound2.start();
    }

    @OnClick(R.id.button2)
    public void onClick2() {
        oturikingaku = goukeikingaku - kakaku2kingaku;
        toridasiguchi.setImageDrawable(syasin2.getDrawable());
        oturihyouji.setText(String.valueOf(oturikingaku));
        buttonAllOff();
        sound2.start();
    }

    @OnClick(R.id.button3)
    public void onClick3() {
        oturikingaku = goukeikingaku - kakaku3kingaku;
        toridasiguchi.setImageDrawable(syasin3.getDrawable());
        oturihyouji.setText(String.valueOf(oturikingaku));
        buttonAllOff();
        sound2.start();
    }

    @OnClick(R.id.toridasiguchi)
    public void onClick() {
        if (toridasiguchi.getDrawable() != null) {
            toridasiguchi.setImageDrawable(null);
            goukeikingaku = 0;
            goukeihyouji.setText("");
            oturikingaku = 0;
            oturihyouji.setText("");
        }
    }
}
