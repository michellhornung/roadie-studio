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
			
			events: {
				url: window.location.origin+'/calendar/getEventos.json'
			}
		});
		
	});