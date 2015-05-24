# GoogleRainbowBar
### 简介
一个自定义View实现的彩虹进度条，类似Google官方效果，可以通过配置下列参数用在自己的项目中：
>1. `space` 进度条之间的间距
>2. `barwidth` 进度条宽度
>3. `barheight` 进度条高度
>4. `barcolor` 进度条颜色

### 代码示例
```
<com.yuxingxin.googlerainbowbar.RainbarView
    android:layout_width="match_parent"
    android:layout_height="80dp"
    app:barcolor="#FDBB2C"
    app:barwidth="80dp"
    app:space="10dp"
/>
```
**[注意]不要忘记在你的页面根布局中添加下面一行代码：**
```
xmlns:app="http://schemas.android.com/apk/res-auto"
```
### 最后来一个截屏
![image](https://github.com/yuxingxin/GoogleRainbowBar/blob/master/screenshots/screen.png)
