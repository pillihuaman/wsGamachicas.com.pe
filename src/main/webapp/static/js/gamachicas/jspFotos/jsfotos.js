// A $( document ).ready() block.
$( document ).ready(function() {
    console.log( "ready!" );
    
});



	
	
const el = document.querySelector("#myresultdo");

el.addEventListener("mousemove", (e) => {
  el.style.backgroundPositionX = -e.offsetX + "px";
  el.style.backgroundPositionY = -e.offsetY + "px";
});

 function MostrarImagen(id) {
	 debugger;
	var jqueyElement='#';
	 var r= $(jqueyElement.concat(id));
	 var ulrimg=$(r).attr('src');
	  //var estylo= ' width: 600px; '+   ' height: 300px;'+   ' border: 1px solid white; '+  ' background-size: 1000px; '+  ' background-image:'+ 'url('+ulrimg+')';
	 var estylo= ' border: 1px solid white; '+  ' background-size: 1000px; '+  ' background-image:'+ 'url('+ulrimg+')';
	 $(".myresultdo").attr('style',estylo);
}

 function zoomout(){
	

	    var myImg = document.getElementById("imgbox");
	    var currWidth = myImg.clientWidth;

	    if(currWidth >= 400){
	    	  myImg.style.width = (currWidth - 400) + "px";
	    	  myImg.style.height = (currWidth - 400) + "px";
	    } else{
	        myImg.style.width = (currWidth + 400) + "px";
	        myImg.style.height = (currWidth + 400) + "px";
	    }
	}