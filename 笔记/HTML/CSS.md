## CSS

1. 选择器

   1. 元素选择器

      ```css
      //对所有p元素生效
      p{
        text-align:center;
        color:red;
      }
      ```

   2. 分组选择器（元素选择器的扩展，一次弄多个元素）

      ```css
      //对所有p、div元素生效
      p,div{
        text-align:center;
        color:red;
      }
      ```

   3. id选择器

      ```css
      //对id为hello的元素生效
      #hello{
        text-align:center;
        color:red;
      }
      ```

   4. 类选择器

      ```css
      //对所有带有 class="center" 的元素生效
      .center{
        text-align: center;
        color: red;
      }
      //指定元素，仅对p元素且带有class="center" 生效
      p.center{
        
      }
      ```

   5. 通用选择器

      ```css
      //对所有元素生效
      *{
          text-align: center;
        	color: red;
      }
      ```

2. 颜色

   1. 支持140种标准颜色名

   2. 设置颜色

      1. 通过名称
      2. HEX
         1. #777777
      3. RGB

         1. rgb(x,x,x)
         2. rgba(x,x,x,a)

3. 背景

   1. 背景色

      ```css
      div{
      	background-color:red;
        //这里的透明度会对影响到元素以及子元素，如果只想给元素背景设置透明度可以在background-color中设置颜色的透明度
        opacity:0.3
      }
      ```

   2. 背景图：

      ```css
      //默认在水平和垂直两个方向上都重复
      body {
        background-image: url("bgdesert.jpg");
      }
      ```

   3. 指定背景重复

      ```css
      body {
        background-image: url("/i/css/gradient_bg.png");
        //只在垂直方向上重复，repeat-y、repeat-x、no-repeat
        background-repeat: repeat-y;
      }
      ```

   4. 不重复的图像指定位置

      ```css
      body {
        background-image: url("tree.png");
        background-repeat: no-repeat;
        //图像位于右上角
        background-position: right top;
      }
      ```

   5. 背景附着

      ```css
      //设置背景图是固定的还是滚动的（相对元素内的内容），fixed、scroll
      body {
        background-image: url("tree.png");
        background-repeat: no-repeat;
        background-position: right top;
        background-attachment: fixed;
      }
      ```

      | [background-attachment](https://www.w3school.com.cn/cssref/pr_background-attachment.asp) | 设置背景图像是固定的还是与页面的其余部分一起滚动。 |
      | ------------------------------------------------------------ | -------------------------------------------------- |
      | [background-clip](https://www.w3school.com.cn/cssref/pr_background-clip.asp) | 规定背景的绘制区域。                               |
      | [background-color](https://www.w3school.com.cn/cssref/pr_background-color.asp) | 设置元素的背景色。                                 |
      | [background-image](https://www.w3school.com.cn/cssref/pr_background-image.asp) | 设置元素的背景图像。                               |
      | [background-origin](https://www.w3school.com.cn/cssref/pr_background-origin.asp) | 规定在何处放置背景图像。                           |
      | [background-position](https://www.w3school.com.cn/cssref/pr_background-position.asp) | 设置背景图像的开始位置。                           |
      | [background-repeat](https://www.w3school.com.cn/cssref/pr_background-repeat.asp) | 设置背景图像是否及如何重复。                       |
      | [background-size](https://www.w3school.com.cn/cssref/pr_background-size.asp) | 规定背景图像的尺寸。                               |

4. 边框-border

   1. border-style:有多种，常用为solid，参见菜鸟教程

      ```css
      /*单独设置某一边的样式*/
      p {
        border-top-style: dotted;
        border-right-style: solid;
        border-bottom-style: dotted;
        border-left-style: dash;
      }
      ```

      

   2. border-width

      ```css
      p{
        border-style: solid;
        /*设置一个值则代表 上下左右*/
        border-width: 1px; 
      }
      p{
        border-style: solid;
        /*设置两个值则代表 上下、左右*/
        border-width: 0px 1px; 
      }
      p{
        border-style: solid;
        /*连续设置四个值则代表 上、右、下、左*/
        border-width: 0px 0px 1px 0px; 
      }
      ```

5. border-color 同border-width

6. border-radius

   ```css
   p {
     border: 2px solid red;
     border-radius: 5px;
   }
   
   p {
     border: 2px solid red;
     /*设置右上角的圆角，其他几个角同理*/
     border-top-right-radius: 5px;
   }
   ```

5. 外边距-margin
   1. auto：该元素将占据指定的宽度，并且剩余空间将在左右边界之间平均分配，即水平居中
   2. inherit：继承父元素的外边距
6. 字体
   1. 字体名字：font-family
   2. 字体粗细：font-weight
   3. 字体大小：font-size
   4. 
7. 2
8. 3
9. 4
10. 