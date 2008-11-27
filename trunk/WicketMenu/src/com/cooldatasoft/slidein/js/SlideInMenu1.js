/***********************************************
* Sliding Menu Bar Script- © Dynamic Drive (www.dynamicdrive.com)
* Visit http://www.dynamicdrive.com/ for full source code
* This notice must stay intact for use
***********************************************/
alert("ok");
var slidemenu_width='160px' //specify width of menu (in pixels)
var slidemenu_reveal='12px' //specify amount that menu should protrude initially
var slidemenu_top='170px'   //specify vertical offset of menu on page

var ns4=document.layers?1:0
var ie4=document.all
var ns6=document.getElementById&&!document.all?1:0

if (ie4||ns6)
document.write('<div id="slidemenubar2" style="left:'+((parseInt(slidemenu_width)-parseInt(slidemenu_reveal))*-1)+'px; top:'+slidemenu_top+'; width:'+slidemenu_width+'" onMouseover="pull()" onMouseout="draw()">')
else if (ns4){
document.write('<style>\n#slidemenubar{\nwidth:'+slidemenu_width+';}\n<\/style>\n')
document.write('<layer id="slidemenubar" left=0 top='+slidemenu_top+' width='+slidemenu_width+' onMouseover="pull()" onMouseout="draw()" visibility=hide>')
}

var sitems=new Array()

///////////Edit below/////////////////////////////////

//siteitems[x]=["Item Text", "Optional URL associated with text"]
/*
sitems[0]=["<big><font face='Arial'>Site Menu</font></big>", ""]
sitems[1]=["Menus And Navigation", "http://www.dynamicdrive.com/dynamicindex1/"]
sitems[2]=["Document Effects", "http://www.dynamicdrive.com/dynamicindex3/"]
sitems[3]=["Scrollers", "http://www.dynamicdrive.com/dynamicindex2/"]
sitems[4]=["Image Effects", "http://www.dynamicdrive.com/dynamicindex4/"]
sitems[5]=["Links And Buttons", "http://www.dynamicdrive.com/dynamicindex5/"]
sitems[6]=["Dynamic Clocks & Dates", "http://www.dynamicdrive.com/dynamicindex6/"]
sitems[7]=["Text Animations", "http://www.dynamicdrive.com/dynamicindex10/"]
sitems[8]=["Browser Window", "http://www.dynamicdrive.com/dynamicindex8/"]
sitems[9]=["User System Information", "http://www.dynamicdrive.com/dynamicindex9/"]
sitems[10]=["Other", "http://www.dynamicdrive.com/dynamicindex11/"]
*/
//If you want the links to load in another frame/window, specify name of target (ie: target="_new")
var target=""

/////////////////////////////////////////////////////////

if (ie4||ns4||ns6){
for (i=0;i<sitems.length;i++){
if (sitems[i][1])
document.write('<a href="'+sitems[i][1]+'" target="'+target+'">')
document.write(sitems[i][0])
if (sitems[i][1])
document.write('</a>')
document.write('<br>\n')
}
}

function regenerate(){
window.location.reload()
}
function regenerate2(){
if (ns4){
document.slidemenubar.left=((parseInt(slidemenu_width)-parseInt(slidemenu_reveal))*-1)
document.slidemenubar.visibility="show"
setTimeout("window.onresize=regenerate",400)
}
}
window.onload=regenerate2

rightboundary=0
leftboundary=(parseInt(slidemenu_width)-parseInt(slidemenu_reveal))*-1

if (ie4||ns6){
document.write('</div>')
themenu=(ns6)? document.getElementById("slidemenubar2").style : document.all.slidemenubar2.style
}
else if (ns4){
document.write('</layer>')
themenu=document.layers.slidemenubar
}

function pull(){
if (window.drawit)
clearInterval(drawit)
pullit=setInterval("pullengine()",10)
}
function draw(){
clearInterval(pullit)
drawit=setInterval("drawengine()",10)
}
function pullengine(){
if ((ie4||ns6)&&parseInt(themenu.left)<rightboundary)
themenu.left=parseInt(themenu.left)+10+"px"
else if(ns4&&themenu.left<rightboundary)
themenu.left+=10
else if (window.pullit){
themenu.left=0
clearInterval(pullit)
}
}

function drawengine(){
if ((ie4||ns6)&&parseInt(themenu.left)>leftboundary)
themenu.left=parseInt(themenu.left)-10+"px"
else if(ns4&&themenu.left>leftboundary)
themenu.left-=10
else if (window.drawit){
themenu.left=leftboundary
clearInterval(drawit)
}
}
