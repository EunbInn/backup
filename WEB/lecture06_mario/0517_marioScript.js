let score = 0; // 점수 전역변수로 선언 후 초기화
let isEnd = false;
let lifeCnt = 0;
let lifeImg = document.getElementsByClassName('heart');
$(function () {
    let gameStop = setInterval(function () {
        moveMush();

        if (isEnd == true) {
            clearInterval(gameStop);
        }
  
    }, 2000);
    ///sleep 다시 확인할 것
    let checkLife = setInterval(async function () {
        if (marioDead()) {
            if (lifeCnt == 2) {
                $('#enemy').stop(true);
                let htmlCode = "<img src='./gameover.png' id='overImg'>"
                    + "<button id='retry'>Try Again</button>";
                $('#gameover').html(htmlCode);
                $('#mario').attr('src', './marioDead2.gif');
                Bye();
                $('.heart:eq(' + (lifeCnt) + ')').hide();
                isEnd = true;
                clearInterval(gameStop);
                $('#retry').click(function () {
                    document.location.href = "./0517_mario_intro.html";
                });

            } else {
                sleep(500);
                score -= 100;
                $('.heart:eq(' + (lifeCnt) + ')').hide();
                lifeCnt += 1;
            }

        } else {
            isEnd = false;
        }
        console.log(lifeCnt);
        // console.log(isEnd);
    }, 50);

    setInterval(function () {
        if (fireAndMush()) {
            score += 200;
            showScore();
            $('#enemy').stop(true);
            $('#enemy').css('left', '120%');
            $('#fireball').stop();
            $('#fireball').css('left', '-30%');
        }
    });

})

    
//버섯 달려오는 속도 랜덤하게 주기
function moveMush() {
        var speed = Math.ceil(Math.random() * 2000) + 1500; 
        $('#enemy').animate({
            left: '-10%' 
            },speed , function() {
                if (!marioDead()) {
                    score += 100;
                    showScore();
                }
                $('#enemy').css('left', '120%');
                    
        });    
}

function sleep (delay) {
    var start = new Date().getTime();
    while (new Date().getTime() < start + delay);
}



function marioDead() {
    var marioX = $('#mario').offset().left - $('#enemy').offset().left;
    var marioY = $('#mario').offset().top - $('#enemy').offset().top;
   
    let distance = Math.sqrt((marioX * marioX) + (marioY * marioY));
    let over = 100;
    let dead = distance <= over;
    return dead;      
}

//파이어볼과 버섯 충돌감지
function fireAndMush() {
    var obX = $('#fireball').offset().left - $('#enemy').offset().left;
    var obY = $('#fireball').offset().top - $('#enemy').offset().top;
    let distance = Math.sqrt((obX * obX) + (obY * obY));
    let over = 100;
    let hit = distance <= over;
    if (hit) {
        
    }
    return hit;      
}

//마리오 점프모션
let isJump = false;
function jump() {
    if(isJump) {
        return;
    }

    isJump = true;
    $('#mario').attr('src', './marioJump.png');
    setTimeout(function(){
        $('#mario').attr('src', './mariorun2.gif');
    },700);
    
    $('#mario').animate({
            top: '-=140px',
            left: '+=40px'
    },300, function() {
        $('#mario').animate({
            top: '+=140px',
            left: '-=10px'
        },400, function() {  
            $('#mario').animate({
                left:  '-=30px'
            },200, function() {
                isJump = false;
            });
        });
    });
}

//마리오의 장풍..
let isFire = false;
function fireball() {
    if(isFire) {
        return;
    }
    isFire = true;
    let marioY = $('#mario').position().top + 40;
    let marioX = $('#mario').position().left + 20;
    $('#fireball').css({'top': marioY, 'left': marioX});
    $('#fireball').animate({
        left: '40%'
    }, 400, function(){
        $('#fireball').css('left', '-20%');
    });
    isFire = false;
}


window.addEventListener('keydown', function(event) {
    if (event.code == 'Space') {
        jump();
    }

    if (event.code == 'Enter') {  
        fireball(); 
    }
    
})

function Bye() {
    $('#mario').animate({
        top: '-=190px',
        left: '+=40px',
    },400).animate({
            top: '+=500px'
        }, 1000);
    
}

function showScore() {
    $('#score').html('score ' + score);
}