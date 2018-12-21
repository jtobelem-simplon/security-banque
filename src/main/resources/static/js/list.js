
/**
 * @author tobelem
 */
//on associe les clicks d'objet html avec des fonctions
$(document).ready(function() {

	//load of datatable
	loadDataOption();
	

	$("#compteList").click(selectCompte);

//	dblclik on datatable
	$('#employeeTable tbody').on( 'dblclick', 'tr', selectRow);



});



///////////////////////////////////////////////////////////////////////////////


/**
 * loadDatatable
 **/
function selectCompte() {
	compteList = document.getElementById('compteList');

	if (compteList.selectedIndex > -1) {
		var url = "/api/operationsByCompte/"+compteList.options[compteList.selectedIndex].value;
		console.log(">> "+compteList.selectedIndex+" : "+url);
		$('#operationTable').DataTable().ajax.url(url).load();
	}
}


/**
 * loadDatatable
 **/
function loadDataTable() {



	var url = "/api/operationsByCompte/"+compteList.options[compteList.selectedIndex].value;
	console.log(">> load"+compteList.selectedIndex+url);
	$('#operationTable').DataTable({


		"ajax" : {
			url : url,
			"dataSrc" : function (json) {
				return json;
			}
		},
		"columns" : [
			{"data" : "numerooperation"},
			{"data" : "montant"},
			{"data" : "dateoperation"},
			{"data" : "libelleoperation"},
			{"data" : "typeoperation"}
			]
	});


}

function loadDataOption() {
	$.ajax({
		type : "GET",						    
		contentType : "application/json",		
		url : "/api/comptes",				
		dataType : 'json',					
		success : function(data) {

			compteList = document.getElementById('compteList');
			// on vide les options
			for (var i = 0; i < compteList.options.length; i++) {
				compteList.remove(i);
			}

			data.forEach(function(element) {
				compteList.options[compteList.options.length]= new Option(element.numerocompte);
			});
			
			if (compteList.options.length > 0) {
				compteList.selectedIndex = 0;
				loadDataTable();
			}
			


		},
		error : function(e) {
			console.log("ERROR : ", e);
		}
	});
}

/**
 * select
 **/
function selectRow(){
	var table = $('#employeeTable').DataTable();
	let dataRow = table.row( this ).data();
	$("#id").val(dataRow.id);
	$("#name").val(dataRow.name);
}

