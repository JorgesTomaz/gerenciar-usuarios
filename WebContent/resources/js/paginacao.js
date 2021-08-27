function paginacao(){
	$(".table").DataTable({
		  "ordering":false,
		  "info":false,
		  "searching": false,
		  "autoWidth": false,
		  "lengthChange": false,
		  "pageLength": 5,
		  "responsive": true,
		  "language": {
			  "paginate": {
				  "previous": "<",
				  "next": ">"
			  }
		  }
		})	
}

$("document").ready(function(){
	paginacao()
})