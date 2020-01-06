
function goChart(){
    var income_other_all = [[${expend_other_all}]];

    var sponsor_all  = [[${bonus_all}]];

    var studnet_all = [[${salary_all}]];

    var dataArr1 = [ [income_other_all,"#C630C8","玉米"],[sponsor_all,"#2dc6c8","瓜子"], [studnet_all,"#b6a2dd", "花生"]];
    // 声明所需变量
    var canvas1,ctx1;
    // 图表属性
    var cWidth1, cHeight1, cMargin1, cSpace1;
    // 饼状图属性
    var radius1,ox1,oy1;//半径 圆心
    var tWidth1, tHeight1;//图例宽高
    var posX1, posY1, textX1, textY1;
    var startAngle1, endAngle1;
    var totleNb1;
    // 运动相关变量
    var ctr1, numctr1, speed1;
    //鼠标移动
    var mousePosition1 = {};

    //线条和文字
    var lineStartAngle1,line1,textPadding1,textMoveDis1;

    // 获得canvas上下文
    canvas1 = document.getElementById("chart1");
    if(canvas1 && canvas1.getContext){
        ctx1 = canvas1.getContext("2d");
    }
    initChart();

    // 图表初始化
    function initChart(){
        // 图表信息
        cMargin1 = 20;
        cSpace1 = 40;

        canvas1.width = canvas1.parentNode.getAttribute("width")* 2 ;
        canvas1.height = canvas1.parentNode.getAttribute("height")* 2;
        canvas1.style.height = canvas1.height/2 + "px";
        canvas1.style.width = canvas1.width/2 + "px";
        cHeight1 = canvas1.height - cMargin1*2;
        cWidth1 = canvas1.width - cMargin1*2;

        //饼状图信息
        radius1 = cHeight1*2/6;  //半径  高度的2/6
        ox1 = canvas1.width/2 + cSpace1;  //圆心
        oy1 = canvas1.height/2;
        tWidth1 = 60; //图例宽和高
        tHeight1 = 20;
        posX1 = cMargin1;
        posY1 = cMargin1;   //
        textX1 = posX1 + tWidth1 + 15
        textY1 = posY1 + 18;
        startAngle1 = endAngle1 = 90*Math.PI/180; //起始弧度 结束弧度
        rotateAngle = 0; //整体旋转的弧度

        //将传入的数据转化百分比
        totleNb1 = 0;
        new_data_arr1 = [];
        for (var i = 0; i < dataArr1.length; i++){
            totleNb1 += dataArr1[i][0];
        }
        for (var i = 0; i < dataArr1.length; i++){
            new_data_arr1.push( dataArr1[i][0]/totleNb1 );
        }
        totalYNomber = 10;
        // 运动相关
        ctr1 = 1;//初始步骤
        numctr1 = 50;//步骤
        speed1 = 1.2; //毫秒 timer速度

        //指示线 和 文字
        lineStartAngle1 = -startAngle1;
        line1=40;         //画线的时候超出半径的一段线长
        textPadding1=10;  //文字与线之间的间距所示
        textMoveDis1 = 200; //文字运动开始的间距
    }

    //  drawMarkers();
    //绘制比例图及文字
    function drawMarkers(){
        ctx1.textAlign="left";
        for (var i = 0; i < dataArr1.length; i++){
            //绘制比例图及文字
            //ctx1.fillStyle = dataArr1[i][1];
            ctx1.fillRect(posX1, posY1 + 40 * i, tWidth1, tHeight1);
            ctx1.moveTo(posX1, posY1 + 40 * i);
            ctx1.font = 'normal 20px 微软雅黑';    //斜体 30像素 微软雅黑字体
            ctx1.fillStyle = dataArr1[i][1]; //"#000000";
            var percent = dataArr1[i][2] + "：" + dataArr1[i][0] ;
            //	var percent = dataArr1[i][2] + "：" + parseInt(100 * new_data_arr[i]) + "%";

            ctx1.fillText(percent, textX1, textY1 + 40 * i);
        }
    };

    //绘制动画
    pieDraw();
    function pieDraw(mouseMove1){

        for (var n = 0; n < dataArr1.length; n++){
            ctx1.fillStyle = ctx1.strokeStyle = dataArr1[n][1];
            ctx1.lineWidth=1;
            var step = new_data_arr1[n]* Math.PI * 2; //旋转弧度
            var lineAngle = lineStartAngle1+step/2;   //计算线的角度
            lineStartAngle1 += step;//结束弧度

            ctx1.beginPath();
            var  x0=ox1+radius1*Math.cos(lineAngle),//圆弧上线与圆相交点的x坐标
                y0=oy1+radius1*Math.sin(lineAngle),//圆弧上线与圆相交点的y坐标
                x1=ox1+(radius1+line1)*Math.cos(lineAngle),//圆弧上线与圆相交点的x坐标
                y1=oy1+(radius1+line1)*Math.sin(lineAngle),//圆弧上线与圆相交点的y坐标
                x2=x1,//转折点的x坐标
                y2=y1,
                linePadding=ctx1.measureText(dataArr1[n][2]).width+10; //获取文本长度来确定折线的长度

            ctx1.moveTo(x0,y0);
            //对x1/y1进行处理，来实现折线的运动
            yMove = y0+(y1-y0)*ctr1/numctr1;
            ctx1.lineTo(x1,yMove);
            if(x1<=x0){
                x2 -= line1;
                ctx1.textAlign="right";
                ctx1.lineTo(x2-linePadding,yMove);
                ctx1.fillText(dataArr1[n][2],x2-textPadding1-textMoveDis1*(numctr1-ctr1)/numctr1,y2-textPadding1);
            }else{
                x2 += line1;
                ctx1.textAlign="left";
                ctx1.lineTo(x2+linePadding,yMove);
                ctx1.fillText(dataArr1[n][2],x2+textPadding1+textMoveDis1*(numctr1-ctr1)/numctr1,y2-textPadding1);
            }

            ctx1.stroke();

        }

        //设置旋转
        ctx1.save();
        ctx1.translate(ox1, oy1);
        ctx1.rotate((Math.PI*2/numctr1)*ctr1/2);

        //绘制一个圆圈
        ctx1.strokeStyle = "rgba(0,0,0,"+ 0.5*ctr1/numctr1 +")"
        ctx1.beginPath();
        ctx1.arc(0, 0 ,(radius1+20)*ctr1/numctr1, 0, Math.PI*2, false);
        ctx1.stroke();

        for (var j = 0; j < dataArr1.length; j++){

            //绘制饼图
            endAngle1 = endAngle1 + new_data_arr1[j]* ctr1/numctr1 * Math.PI * 2; //结束弧度

            ctx1.beginPath();
            ctx1.moveTo(0,0); //移动到到圆心
            ctx1.arc(0, 0, radius1*ctr1/numctr1, startAngle1, endAngle1, false); //绘制圆弧

            ctx1.fillStyle = dataArr1[j][1];
            if(mouseMove1 && ctx1.isPointInPath(mousePosition1.x*2, mousePosition1.y*2)){
                ctx1.globalAlpha = 0.8;
            }

            ctx1.closePath();
            ctx1.fill();
            ctx1.globalAlpha = 1;

            startAngle1 = endAngle1; //设置起始弧度
            if( j == dataArr1.length-1 ){
                startAngle1 = endAngle1 = 90*Math.PI/180; //起始弧度 结束弧度
            }
        }

        ctx1.restore();

        if(ctr1<numctr1){
            ctr1++;
            setTimeout(function(){
                //ctx1.clearRect(-canvas1.width,-canvas1.width,canvas1.width*2, canvas1.height*2);
                ctx1.clearRect(-canvas1.width, -canvas1.height,canvas1.width*2, canvas1.height*2);
                drawMarkers();
                pieDraw();
            }, speed1*=1.085);
        }
    }

    //监听鼠标移动
    var mouseTimer = null;
    canvas1.addEventListener("mousemove",function(e){
        e = e || window.event;
        if( e.offsetX || e.offsetX==0 ){
            mousePosition1.x = e.offsetX;
            mousePosition1.y = e.offsetY;
        }else if( e.layerX || e.layerX==0 ){
            mousePosition1.x = e.layerX;
            mousePosition1.y = e.layerY;
        }

        clearTimeout(mouseTimer);
        mouseTimer = setTimeout(function(){
            ctx1.clearRect(0,0,canvas1.width, canvas1.height);
            drawMarkers();
            pieDraw(true);
        },10);
    });

}
// var allbill = eval("("+'${jsondata}'+")");
//

// var allbill = [[${jsondata}]];
// var data = JSON.parse(allbill);

//document.getElementById("message2").innerHTML = "Thymeleaf String by JS: " + [[${message2}]];
var expend_other_all = [[${expend_other_all}]];

var bonus_all  = [[${bonus_all}]];

var salary_all = [[${salary_all}]];

var chartData1 = [ [expend_other_all,"#C630C8","玉米"],[bonus_all,"#2dc6c8","瓜子"], [salary_all,"#b6a2dd", "花生"]];
//var chartData1 =[[200,"#2dc6c8","瓜子"], [80,"#b6a2dd", "花生"], [200,"#5ab1ee","土豆"], [100,"#d7797f","南瓜四号"]];


goChart(chartData1);


