package com.wny2023.ex95webapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    val wv:WebView by lazy { findViewById(R.id.wv) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //webview 기본 설정
        wv.settings.javaScriptEnabled=true //웹뷰 설정객체를 통해 JS사용을 허용하도록 변경설정

        wv.webViewClient= WebViewClient() //새로운 웹문서가 열릴때 기본 웹뷰는 새탭으로 열림
        //다른 웹브라우저에서 열리는 것을 방지하기 위해 설정> 최신버젼에는 해결되나 이전버젼일수 있으므로
        wv.webChromeClient= WebChromeClient() //alert(), confirm() 같은 팝업기능 사용가능하게 해줌(원래는막힘)

        //웹뷰가 보여줄 웹문서(.html)로드하기
        //웹문서가 있는 위치는 프로젝트 안에 있거나 웹서버에 위치할 수 있음
        //1. 프로젝트 안에 assets 폴더안에 html 문서 위치
//        wv.settings.allowFileAccess=true
//        wv.loadUrl("file:///android_asset/index.html")
        //2. 닷홈 or AWS 같은 웹서버에 html 문서가 존재
        wv.loadUrl("http://tjdrjs0803.dothome.co.kr/TeamProject")

    }

    override fun onBackPressed() {
        if(wv.canGoBack()) wv.goBack()
        else finish()
    }

}