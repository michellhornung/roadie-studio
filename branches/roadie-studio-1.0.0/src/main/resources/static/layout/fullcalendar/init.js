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
				
				var title = prompt('Titulo do Evento:', calEvent.title, { buttons: { Ok: true, Cancel: false} });
				
				var events = {
					"id":		calEvent.id,
					"title": 	calEvent.title,
					"start": 	calEvent.start._i,
					"end":		calEvent.end._i
				}
				
				$.ajax({
					type: 'POST',
                    url: '/calendar/setEventos.json',
                    contentType: 'application/json',
                    data: JSON.stringify(events),
                    success: function(result) {
                    	if (result.success) $("#feedback input").attr("value", ""); // clear all the input fields on success
                                //$("#feedback_status").slideDown(250).text(result.message); // show status message with animation
                        },
                        error: function(req, status, error) {
                        	alert("erro " + req.status +" "+ req.statusText);
                        }
                  });
				
				
		        /*if (title){
		        	calEvent.title = title;
		            calendar.fullCalendar('updateEvent',calEvent);
		        }*/
			}
		});
	});