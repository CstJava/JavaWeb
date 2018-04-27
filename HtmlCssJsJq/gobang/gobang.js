window.onload()=function(){
var start = document.getElementById('start');
var gobang = document.getElementById('gobang');
var bottom = document.getElementsByClassName('bottom')[0];
var turn = true; //下棋方：true为白方
var turnWord = document.getElementsByClassName('turn')[0];  //下棋方元素
var round = document.getElementsByClassName('round')[0];	//回合元素
var roundNum = 1;	//回合数/2
var chessNum = new Array(10);
var judgeNum = 1;   //判断是否胜利  5

setInterval(function(){
	var date = new Date();
	document.getElementById('time').innerHTML=date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
},1000);
start.onclick = function(){
	start.style.display="none";
	gobang.style.transform="rotateX(0) translateY(0)";
	startGame();
}

function startGame(){
	var block_move = document.getElementsByClassName('block');
	var block_move_lenght = block_move.length;
	for(var i = 0;i<block_move_lenght;i++){
		block_move[0].remove();
	}
	for(var i = 0;i<10;i++){
		chessNum[i] = new Array(10);  //棋子对象，属性chess为是否下过，color为棋子颜色
	}
	
	for(var i = 0;i<10;i++){
		for(var j=0;j<10;j++){
			chessNum[i][j] = new Object();
			chessNum[i][j].chess = false;
			var block = document.createElement("div");
			block.isChess=false;
			block.i = i;
			block.j = j;
			block.setAttribute('class','block');
			block.style.left=j*10+"%";
			block.style.top=i*10+"%";
			if(i==9){
				block.style.borderBottom="none";
			}
			if(j==9){
				block.style.borderRight="none";
			}
			block.addEventListener('click',function(){
				chess(this);
			});
			bottom.appendChild(block);
		}
	}
}

/**
 * 下棋函数，棋子默认白色
 * @param {Object} e
 */
function chess(block){
	if(!block.isChess&&start.style.display!=""){
		chessNum[block.i][block.j].chess=true;
		var chess = document.createElement("div");
		chess.setAttribute('class','chess');
		if(!turn){
			chessNum[block.i][block.j].color= "black";
			chess.style.background="-webkit-radial-gradient(65% 30%,#3a3434,black)";
			turnWord.innerHTML="白";
			turn=true;
		}else{
			chessNum[block.i][block.j].color= "white";
			turnWord.innerHTML="黑";
			turn=false;
		}
		block.appendChild(chess);
		block.isChess=true;
		round.innerHTML="round "+parseInt(++roundNum/2);
		judge(0,block.i,block.j);
	}
}

/**
 * 判断是否胜利函数
 * @param {Object} num
 * @param {Object} i
 * @param {Object} j
 */
function judge(num,i,j){
	if(judgeNum==5){
		alert(turnWord.innerText+"输了");
		judgeNum=1;
		start.style.display="block";
		return;
	}
	if(num==0){
		//判断右边是否有棋子
		if(j+1<10&&chessNum[i][j+1].chess&&chessNum[i][j].color==chessNum[i][j+1].color){
			judgeNum++;
			judge(1,i,j+1);
		}
		//判断左边是否有棋子
		if(j-1>=0&&chessNum[i][j-1].chess&&chessNum[i][j].color==chessNum[i][j-1].color){
			judgeNum++;
			judge(2,i,j-1);
		}
		//判断下边是否有棋子
		if(i+1<10&&chessNum[i+1][j].chess&&chessNum[i][j].color==chessNum[i+1][j].color){
			judgeNum++;
			judge(3,i+1,j);
		}
		//判断上边是否有棋子
		if(i-1>=0&&chessNum[i-1][j].chess&&chessNum[i][j].color==chessNum[i-1][j].color){
			judgeNum++;
			judge(4,i-1,j);
		}
		//判断左上是否有棋子
		if(i-1>=0&&j-1>=0&&chessNum[i-1][j-1].chess&&chessNum[i][j].color==chessNum[i-1][j-1].color){
			judgeNum++;
			judge(5,i-1,j-1);
		}
		//判断右上是否有棋子
		if(i-1>=0&&j+1>=0&&chessNum[i-1][j+1].chess&&chessNum[i][j].color==chessNum[i-1][j+1].color){
			judgeNum++;
			judge(6,i-1,j+1);
		}
		//判断左下是否有棋子
		if(i+1>=0&&j-1>=0&&chessNum[i+1][j-1].chess&&chessNum[i][j].color==chessNum[i+1][j-1].color){
			judgeNum++;
			judge(7,i+1,j-1);
		}
		//判断右下是否有棋子
		if(i+1>=0&&j+1>=0&&chessNum[i+1][j+1].chess&&chessNum[i][j].color==chessNum[i+1][j+1].color){
			judgeNum++;
			judge(8,i+1,j+1);
		}
	}else if(num==1){
		if(j+1<10&&chessNum[i][j+1].chess&&chessNum[i][j].color==chessNum[i][j+1].color){
			judgeNum++;
			judge(1,i,j+1);
		}
	}else if(num==2){
		if(j-1>=0&&chessNum[i][j-1].chess&&chessNum[i][j].color==chessNum[i+1][j].color){
			judgeNum++;
			judge(2,i,j-1);
		}
	}else if(num==3){
		if(i+1<10&&chessNum[i+1][j].chess&&chessNum[i][j].color==chessNum[i+1][j].color){
			judgeNum++;
			judge(3,i+1,j);
		}
	}else if(num==4){
		if(i-1>=0&&chessNum[i-1][j].chess&&chessNum[i][j].color==chessNum[i-1][j].color){
			judgeNum++;
			judge(4,i-1,j);
		}
	}else if(num==5){
		if(i-1>=0&&j-1>=0&&chessNum[i-1][j-1].chess&&chessNum[i][j].color==chessNum[i-1][j-1].color){
			judgeNum++;
			judge(5,i-1,j-1);
		}
	}else if(num==6){
		if(i-1>=0&&j+1>=0&&chessNum[i-1][j+1].chess&&chessNum[i][j].color==chessNum[i-1][j+1].color){
			judgeNum++;
			judge(6,i-1,j+1);
		}
	}else if(num==7){
		if(i+1>=0&&j-1>=0&&chessNum[i+1][j-1].chess&&chessNum[i][j].color==chessNum[i+1][j-1].color){
			judgeNum++;
			judge(7,i+1,j-1);
		}
	}else if(num==8){
		if(i+1>=0&&j+1>=0&&chessNum[i+1][j+1].chess&&chessNum[i][j].color==chessNum[i+1][j+1].color){
			judgeNum++;
			judge(8,i+1,j+1);
		}
	}
	judgeNum=1;
}
}
