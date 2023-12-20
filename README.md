# sim-applet-helloworld

## 概要

[NTTコミュニケーションズ株式会社](https://www.ntt.com/)より提供されている、[IoT Connect Mobile Type S](https://sdpf.ntt.com/services/icms/)のeSIMにインストール可能なアプレットを作るためのサンプルプロジェクトです。  
Windows環境の[IntelliJ IDEA](https://www.jetbrains.com/ja-jp/idea/) CommunityまたはUltimateに対応しています。

## 開発

> [!WARNING]  
> このリポジトリのサブモジュールに含まれるJCDKは、Oracle社の著作物です。  
> 利用する場合は、 `Java Card Development Kit Tools (06_July_2021)` の利用規約に同意する必要があります。  
> https://github.com/martinpaljak/oracle_javacard_sdks/tree/e305a1a0b9bf6b9a8b0c91a9aad8d73537e7ff1b/jc310r20210706_kit/legal

1. このリポジトリをサブモジュールを含めてcloneする

```powershell
git clone --recursive 'https://github.com/common-creation/sim-applet-helloworld.git'
```

2. [lib/download_apifiles.bat](./lib/download_apifiles.bat)を実行して、UICC Toolkitをダウンロード・展開する

> [!NOTE]  
> このバッチファイルは[NTTコミュニケーションズ株式会社](https://www.ntt.com/)より提供されている[ドキュメント](https://sdpf.ntt.com/services/docs/icms/service-descriptions/applet/sample_applet/sample_applet.html#/api-usim-apiuicc-api)に含まれています。  

```powershell
.\lib\download_apifiles.bat
```

3. IntelliJ IDEAで読み込む

![](https://i.imgur.com/8iDN7Vp.png)

4. `Build` を実行すると、 `.\suncap\helloworld.cap` が生成される

![](https://i.imgur.com/pdPD9QB.png)

## QuickOpsを利用したビルド

[QuickOps](https://quickops.sh)を利用して、ビルド・アーティファクト保存をすることもできます。  
[.quickops.yaml](./.quickops.yaml)を同梱しているので、このリポジトリをBacklog Gitに移行すると、すぐに利用できます。
