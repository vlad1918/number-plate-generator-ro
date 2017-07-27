$('#personal').click(function() {
	$.get("/personal", function( data ) {
			$('#plate').html(data);
			$('#plate').css( "color", "black");
	});
});

$('#leasing').click(function() {
	$.get("/leasing", function( data ) {
			$('#plate').html(data);
			$('#plate').css( "color", "red");
	});
});

$('#diplomatic').click(function() {
	$.get("/diplomatic", function( data ) {
			$('#plate').html(data);
			$('#plate').css( "color", "blue");
	});
});

$('#army').click(function() {
	$.get("/army", function( data ) {
			$('#plate').html(data);
			$('#plate').css( "color", "black");
	});
});