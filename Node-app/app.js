const http = require("http");
const fs = require("fs");
const ejs = require("ejs");
const url = require("url");
const mine = {
  ".html": "text/html",
  ".css": "text/css"
};

const indexPage = fs.readFileSync("./index.ejs", "utf8");
const otherPage = fs.readFileSync("./other.ejs", "utf8");
const styleCss = fs.readFileSync("./style.css", "utf8");
const qs = require("querystring"); // 追加分

var server = http.createServer(getFromClient);

server.listen(3000);
console.log("Server Start!");

// メインプログラム===============================

// createServerの処理
function getFromClient(request, response) {
  var urlParts = url.parse(request.url, true);
  switch (urlParts.pathname) {
    case "/":
      responseIndex(request, response);

      break;

    case "/other":
      responseOther(request, response);
      break;

    case "/style.css":
      response.writeHead(200, { "Content-Type": "text/css" });
      response.write(styleCss);
      response.end();
      break;

    default:
      response.writeHead(200, { "Content-Type": "text/plain" });
      response.end("no page...");
      break;
  }
}

// 追加するデータ用変数
var data = { msg: "no message..." };

function responseIndex(request, response) {
  // POSTアクセス時の処理
  if (request.method == "POST") {
    var body = "";

    // データ受信のイベント処理
    request.on("data", data => {
      body += data;
    });

    // データ受信終了のイベント処理
    request.on("end", () => {
      // データベース
      data = qs.parse(body);
      writeIndex(request, response);
    });
  } else {
    writeIndex(request, response);
  }
}

// indexの表示の作成
function writeIndex(request, response) {
  var msg = "伝言を表示します。";
  var cookie_data = getCookie("msg", request);
  var content = ejs.render(indexPage, {
    title: "Index",
    content: msg,
    data: data,
    cookie_data: cookie_data
  });
  response.writeHead(200, { "Content-Type": "text/html" });
  response.write(content);
  response.end();
}

// クッキー値の設定
function writeCookie(key, value, response) {
  var cookie = escape(value);
  response.setHeader("Set-Cookie", [key + "=" + cookie]);
}

// クッキー値の取得
function getCookie(key, request) {
  var cookie_data =
    request.headers.cookie != undefined ? request.headers.cookie : "";
  var data = cookie_data.split(";");
  for (var i in data) {
    if (data[i].trim().startsWith(key + "=")) {
      var result = data[i].trim().substring(key.lengthb + 1);
      return unescape(result);
    }
  }
  return "";
}

var data2 = {
  Taro: ["taro@yamada", "09-999-999", "Tokyo"],
  Hanako: ["hanako@flower", "080-888-888", "Yokohama"],
  Sachiko: ["sachi@happy", "070-777-777", "Nagoya"],
  Ichiro: ["ichi@baseball", "060-666-666", "USA"]
};

// otherのアクセス処理
function responseOther(request, response) {
  var msg = "これはOtherページです。";

  var content = ejs.render(otherPage, {
    title: "Other",
    content: msg,
    data: data2,
    filename: "dataItem"
  });

  // // POSTアクセス時の処理
  // if (request.method == "POST") {
  //   var body = "";

  //   // データ受信のイベント処理
  //   request.on("data", data => {
  //     body += data;
  //   });

  //   // データ受信終了のイベント処理
  //   request.on("end", () => {
  //     var postData = qs.parse(body);
  //     msg += "あなたは、「" + postData.msg + "」と書きました。";
  //     var content = ejs.render(otherPage, {
  //       title: "Other",
  //       content: msg
  //     });
  //     response.writeHead(200, { "Content-Type": "text/html" });
  //     response.write(content);
  //     response.end();
  //   });

  //   // GETアクセス時の処理
  // } else {
  //   var msg = "ページがありません。";
  //   var content = ejs.render(otherPage, {
  //     title: "Other",
  //     content: msg
  //   });
  response.writeHead(200, { "Content-Type": "text/html" });
  response.write(content);
  response.end();
}
