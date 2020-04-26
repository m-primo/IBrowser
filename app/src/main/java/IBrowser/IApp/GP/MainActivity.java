package IBrowser.IApp.GP;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import java.util.*;
import java.text.*;


public class MainActivity extends Activity {

	private LinearLayout linear2;
	private LinearLayout barbtns;
	private ScrollView vscroll1;
	private LinearLayout bottomlinear;
	private LinearLayout topliner;
	private ImageView go;
	private EditText url;
	private ImageView about;
	private ImageView back;
	private ImageView reload;
	private ImageView forward;
	private ImageView zoomin;
	private ImageView zoomout;
	private WebView browse;
	private WebView adview;

	private String urlvar = "";


	private AlertDialog.Builder d_q;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		barbtns = (LinearLayout) findViewById(R.id.barbtns);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		bottomlinear = (LinearLayout) findViewById(R.id.bottomlinear);
		topliner = (LinearLayout) findViewById(R.id.topliner);
		go = (ImageView) findViewById(R.id.go);
		url = (EditText) findViewById(R.id.url);
		about = (ImageView) findViewById(R.id.about);
		back = (ImageView) findViewById(R.id.back);
		reload = (ImageView) findViewById(R.id.reload);
		forward = (ImageView) findViewById(R.id.forward);
		zoomin = (ImageView) findViewById(R.id.zoomin);
		zoomout = (ImageView) findViewById(R.id.zoomout);
		browse = (WebView) findViewById(R.id.browse);
		browse.getSettings().setJavaScriptEnabled(true);
		browse.getSettings().setSupportZoom(true);
		browse.setWebViewClient(new WebViewClient() {
				@Override
				public void onPageStarted(WebView _view, String _url, Bitmap _favicon) {

					super.onPageStarted(_view, _url, _favicon);
				}
				@Override
				public void onPageFinished(WebView _view, String _url) {

					super.onPageFinished(_view, _url);
				}
			});
		adview = (WebView) findViewById(R.id.adview);
		adview.getSettings().setJavaScriptEnabled(true);
		adview.getSettings().setSupportZoom(true);
		adview.setWebViewClient(new WebViewClient() {
				@Override
				public void onPageStarted(WebView _view, String _url, Bitmap _favicon) {

					super.onPageStarted(_view, _url, _favicon);
				}
				@Override
				public void onPageFinished(WebView _view, String _url) {

					super.onPageFinished(_view, _url);
				}
			});

		d_q = new AlertDialog.Builder(this);

		url.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence _text, int _start, int _count, int _after) {
				}
				@Override
				public void onTextChanged(CharSequence _text, int _start, int _before, int _count) {
					urlvar = _text.toString();
				}
				@Override
				public void afterTextChanged(Editable _text) {
				}
			});
		go.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _v) { 
					browse.loadUrl(url.getText().toString());
				}
			});
		about.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _v) { 
					d_q.setTitle("About");
					d_q.setMessage(" © ( IApp ) Powered by GP & PWS & Elgeneral Primo \n\n Site : PWS-Apps.BlogSpot.Com \n\n IBrowser V 2.0");
					d_q.setNeutralButton("OK", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {

							}
						});
					d_q.create().show();
				}
			});
		back.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _v) { 
					browse.goBack();
				}
			});
		reload.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _v) { 
					browse.loadUrl(browse.getUrl());
				}
			});
		forward.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _v) { 
					browse.goForward();
				}
			});
		zoomin.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _v) { 
					browse.zoomIn();
				}
			});
		zoomout.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _v) { 
					browse.zoomOut();
				}
			});

	}

	private void  initializeLogic() {
		adview.loadUrl("http://ads-by-pws-proj.lolbb.com/h10-page");
		browse.clearCache(true);
		adview.clearCache(true);
	}

	@Override
	public void onBackPressed() {
		d_q.setTitle("Exit");
		d_q.setMessage("Are you sure for exit?");
		d_q.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					finish();
				}
			});
		d_q.setNegativeButton("No", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {

				}
			});
		d_q.create().show();
	}



}

