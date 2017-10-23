	$(document).ready(function() {
		
		var data = new Date();
		
		/*PEGA O DIA*/
		var dia  = data.getDate();	
		
		/*PEGA O MÊS E SOMA MAIS UM PARA CHEGAR NO MÊS ATUAL(JAVASCRIPT O MÊS COMEÇA EM 0(iNDEX DO MÊS))*/
		var mes  = (data.getMonth() + 1);
		
		/*PEGA O ANO*/
		var ano  = data.getFullYear();
		
		/*MONTA A DATA*/
		var dataAtual = ano +'-'+mes+'-'+dia;
		
		
		$('#calendar').fullCalendar({
			
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay,listWeek'
			},
			defaultDate: dataAtual,
			navLinks: true, // can click day/week names to navigate views
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			lang:'pt-br',
			buttonText: {
			    today: 'Hoje',
			    month: 'Mês',
			    week: 'Semana',
			    day: 'Dia'
			},
			events: {
				url: '/calendar/getEventos.json'
			},
			eventClick: function(calEvent, jsEvent, view) {
				
				//ID DO AGENDAMENTO
				$('#id').val(calEvent.id);
				
				//CAMPO TIPO
				$('#type').val(calEvent.type == 'L' ? 'Locação' : 'Gravação');
				
				//CAMPO DESCRICAO
				$('#description').val(calEvent.title);
				
				//CAMPO START
				if (calEvent.start !== null && calEvent.start !== undefined)
					$('#dtStart').val(calEvent.start.format("DD/MM/YYYY hh:mm"));
				
				//CAMPO END
				if (calEvent.end !== null && calEvent.end !== undefined)
					$('#dtEnd').val(calEvent.end.format("DD/MM/YYYY hh:mm"));
								
				//ABRE MODAL
				$("#openModal").click();
			}
		});
		
		//EDITAR
		$('#submitModal').click(function(){
		    
		    var events = {
					"id":		$('#id').val(),
					"title": 	$('#description').val(),
					"type":		$('#type').val(),
					"start": 	$('#dtStart').val(),
					"end":		$('#dtEnd').val()
			}
		    
		    $.ajax({
				type: 'POST',
	            url: '/calendar/edit',
	            contentType: 'application/json',
	            data: JSON.stringify(events),
	            error: function(req, status, error) {
	               	alert("ERRO AO TENTAR EDITAR O AGENDAMENTO " + $('#description').val());
	            }
	          });
		    
		    $("#closeModal").click();
		    
		});
		
		//REMOVER
		$('#removeModal').click(function(){
		    
		    var events = {
		    		"id":		$('#id').val(),
					"title": 	$('#description').val(),
					"type":		$('#type').val(),
					"start": 	$('#dtStart').val(),
					"end":		$('#dtEnd').val()
			}
		    
		    $.ajax({
				type: 'POST',
	            url: '/calendar/delete',
	            contentType: 'application/json',
	            data: JSON.stringify(events),
	            success: function(result) {
	            	
	                },
	            error: function(req, status, error) {
	            	alert("ERRO AO TENTAR REMOVER O AGENDAMENTO " + $('#description').val());
	            }
	          });
		    
		    $("#closeModal").click();
		    
		});
		
	});
