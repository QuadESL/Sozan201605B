package jp.co.oec_o.oec0155.myjihankib;

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
        sound1 = MediaPlayer.create(this,R.raw.hyun1);
        sound2 = MediaPlayer.create(this,R.raw.touch1);
    }

    private void buttonAllOff() {
        button1.setEnabled(false);
        button1.setBackgroundColor(Color.GRAY);
        button2.setEnabled(false);
        button2.setBackgroundColor(Color.GRAY);
        button3.setEnabled(false);
        button3.setBackgroundColor(Color.GRAY);
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        return false;
    }
}
