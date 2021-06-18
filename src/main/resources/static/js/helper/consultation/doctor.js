$( document ).ready(function() {

	getSchedule();

});

	//--<> HTML
		var btn = {
			b : ['<button class="', '">', '</button>'],
			bid : ['<button id="', '" class="', '" ', '>', '</button>'],
		  	s : {success : 'btn btn-success', danger : 'btn btn-danger', warning: 'btn btn-warning', info:'btn btn-info', default:'btn btn-default'},
		  	a : {call: 'call_row ', end : 'end_row ', delay: 'delay-row ', wait:'wait_row '},
		};

		//--<> Delay Time
		var valTimer = 20;


	//--<> HTML

	//--<> Action
		function doing(id, idDoctor, idStatus, nameStatus, count){
			if ((nameStatus == 'delay') && count == 3) {				
				updateCounter(id, idDoctor, idStatus, nameStatus, count);

			}
			else if ((nameStatus == 'to do' || nameStatus == 'delay') && count <= 3) {		
				updateCounter(id, idDoctor, idStatus, nameStatus, count);

			}else if(nameStatus == 'doing'){
				// doingQueue.push(id);
				delayQueue.shift();
				doingQueue.pop(id);
				remove(id);
				updateCounter(id, idDoctor, idStatus, nameStatus, count);
			}

			// else if(nameStatus == 'delay'){

			// }else if(nameStatus == 'done'){

			// }else if(nameStatus == 'miss'){

			// }else if(nameStatus == 'canceled'){

			// }else if(nameStatus == 'terminate'){

			// }else{

			// }
		}

		function room(id, room){
			window.open (room, "_newtab" );    
			// location.replace(room);
		}
	//--<> Action

	//--<> AJAX
		function getSchedule(){
			var accessUrl = 'http://localhost:8082/consultation/get_schedule/4102158105';
			$.ajax({
				url: accessUrl,
				type: 'GET',
				dataType : "JSON",
					success: function(data){

						if (data == 'false') {
							alert('data not found!!!');
						}else{
							var consultation = data['consultation'];
							console.log(consultation);
							var html = generateRow(consultation);



							$('#consultation').html(html);						
						}
					}
			});
		}

		function updateCounter(id, idDoctor, idStatus, nameStatus, count){
			var accessUrl = 'http://localhost:8082/consultation/update_status/'+id+'/'+idDoctor+'/'+idStatus+'/'+count;
			$.ajax({
				url: accessUrl,
				type: 'GET',
				dataType : "JSON",
				// data : {id : id, idDoctor : idDoctor, idStatus : idStatus, nameStatus : nameStatus, count : count},
					success: function(data){

						console.log(data);
						console.log('counter'+count);

						if (data['consultation'] == 'true') {
							htmlAction = btn.bid[0]+id+
								btn.bid[1]+btn.a.wait+btn.s.default+
								btn.bid[2]+onclick+
								btn.bid[3]+'20'+
								btn.bid[4];

							$('#activeControl').html(htmlAction);
							

							if (count <= 3 && count > 0) {
								counter(id, valTimer);
							}else if(count == 0){
								
								
								getSchedule();
								addQueue(id);
								getQueue();
							}
							
						}else{
							alert('Update Failed !!!');
						}
					}
			});
		}

	//--<> AJAX

	//--<> Parse
		function generateRow(consultation) {
			var id, idDoctor, queue, date, session, employee, idEmployee, status, response, count, action;
			var htmlQueue, htmlDate, htmlEmployee, htmlSession, htmlAction, htmlStatus;
			var html = '';
			var htmlDoing = '';
			var htmlWaiting = '';	
			var htmlDelayON = '';
			var htmlDelayOFF = '';
				delayLenght = consultation.length;

			if (consultation.length > 0) {
				for (var i = 0;  i < consultation.length; i++) {

					id 			= consultation[i].id;
					idDoctor	= consultation[i].id_doctor;
					queue 		= consultation[i].queue;
					date 		= consultation[i].date;
					session		= consultation[i].start_time+' '+consultation[i].end_time;
					employee	= consultation[i].fname_employee+' '+consultation[i].lname_employee;
					idEmployee	= consultation[i].id_employee;
					idStatus	= consultation[i].id_cosultation_status;
					nameStatus	= consultation[i].name_consultation_status;

					response	= consultation[i].response;
					count		= consultation[i].count;

					// console.log(count);

					if (nameStatus == 'to do') {
						htmlStatus 		= '<td><b>WAITING</b></td>';
					}else if(nameStatus == 'doing'){
						htmlStatus 		= '<td><b>DOING</b></td>';
					}else if(nameStatus == 'delay'){
						htmlStatus 		= '<td><b>DELAY</b></td>';
					}

					htmlQueue	 	= '<td id="queueText'+id+'">'+queue+'</td>';
					htmlDate	 	= '<td id="dateText'+id+'">'+date+'</td>';
					htmlEmployee 	= '<td id="employeeText'+id+'">'+employee+'</td>';
					htmlSession 	= '<td id="sessionText'+id+'">'+session+'</td>';
					// htmlStatus 		= '<td id="statusText'+id+'">'+nameStatus+'</td>';

					// getQueue();
					// console.log(doingQueue.length);

					if(nameStatus == 'doing'){
						doingQueue.push(id);
						console.log(doingQueue.length);
						if (i == 0 && doingQueue.length == 1 && response == 'true') {
							var htmlAction = generateButton(consultation[i]);
							htmlDoing += '<tr>'+htmlQueue+htmlDate+htmlSession+htmlEmployee+htmlAction+htmlStatus+'</tr>';
						}

					}else
					if (nameStatus == 'to do') {
						if (i == 0 && doingQueue.length == 0) {
							var htmlAction = generateButton(consultation[i]);
							htmlWaiting += '<tr>'+htmlQueue+htmlDate+htmlSession+htmlEmployee+htmlAction+htmlStatus+'</tr>';
						}else{
							htmlWaiting += '<tr>'+htmlQueue+htmlDate+htmlSession+htmlEmployee+'<td></td>'+htmlStatus+'</tr>';
						}

					}else if(nameStatus == 'delay'){
						var checkValue = getValue(id);

						if (checkValue == false && doingQueue.length == 0) {
							var htmlAction = generateButton(consultation[i]);
							htmlDelayON += '<tr>'+htmlQueue+htmlDate+htmlSession+htmlEmployee+htmlAction+htmlStatus+'</tr>';
						}else if(checkValue == true){
							htmlDelayOFF += '<tr>'+htmlQueue+htmlDate+htmlSession+htmlEmployee+'<td></td>'+htmlStatus+'</tr>';
						}

					}


					// }else if(nameStatus == 'delay'){
					// if (nameStatus == 'to do') {
					// }else if(nameStatus == 'doing'){
					// }else if(nameStatus == 'delay'){
					// }else if(nameStatus == 'done'){
					// }else if(nameStatus == 'miss'){
					// }else if(nameStatus == 'canceled'){
					// }else if(nameStatus == 'terminate'){
					// }else{
					// }

					// html = '<td id="responseText'+id+'">'+response+'</td>';
					// html = '<td id="countText'+id+'">'+count+'</td>';
				}

				html = htmlDoing+htmlWaiting+htmlDelayON+htmlDelayOFF;
				
			}else{
				html = '<tr><td colspan="6">Consultation Empty...</td></tr>';
			}

			return html;
		}	

		function generateButton(arr){
			console.log(arr);
			var turn = 3;
			id 			= arr.id;
			idDoctor	= arr.id_doctor;
			roomDoctor	= arr.room_doctor;
			queue 		= arr.queue;
			date 		= arr.date;
			session		= arr.start_time+' '+arr.end_time;
			employee	= arr.fname_doctor+' '+arr.lname_doctor;
			idEmployee	= arr.id_employee;
			idStatus	= arr.id_cosultation_status;
			nameStatus	= arr.name_consultation_status;

			response	= arr.response;
			count		= arr.count;

				// var aResponse = ' data-response="'+response+'" ';
				// id
				// id_doctor
				// queue
				// id_employee
				// id_cosultation_status
				// name_consultation_status
				// response
				// count

				// if (nameStatus == 'to do') {
				// }elseif(nameStatus == 'doing'){
				// }elseif(nameStatus == 'delay'){
				// }elseif(nameStatus == 'done'){
				// }elseif(nameStatus == 'miss'){
				// }elseif(nameStatus == 'canceled'){
				// }elseif(nameStatus == 'terminate'){
				// }else{
				// }

			var doingFunction, onclick, remain;
			if (nameStatus == 'to do' && count == 3) {
				count = 0;
				idStatus = '3';
				doingFunction = 'doing(&#39;'+id+'&#39;,&#39;'+idDoctor+'&#39;,&#39;'+idStatus+'&#39;,&#39;'+nameStatus+'&#39;,&#39;'+count+'&#39;)';
				onclick = ' onclick="'+doingFunction+'" ';
				// remain = turn-count;
				htmlAction = '<td id="activeControl">'+btn.bid[0]+id+
						btn.bid[1]+btn.a.call+btn.s.danger+
						btn.bid[2]+onclick+
						btn.bid[3]+'DELAY'+
						btn.bid[4]+'</td>';
			}else if ((nameStatus == 'to do' || nameStatus == 'delay') && count < 3) {
				remain = turn-count;
				count = count+1;
				doingFunction = 'doing(&#39;'+id+'&#39;,&#39;'+idDoctor+'&#39;,&#39;'+idStatus+'&#39;,&#39;'+nameStatus+'&#39;,&#39;'+count+'&#39;)';
				onclick = ' onclick="'+doingFunction+'" ';
				htmlAction = '<td id="activeControl">'+btn.bid[0]+id+
						btn.bid[1]+btn.a.call+btn.s.success+
						btn.bid[2]+onclick+
						btn.bid[3]+'CALL ('+remain+')'+
						btn.bid[4]+'</td>';
			}else if(nameStatus == 'delay' && count == 3){
				count = 0;
				idStatus = '3';
				doingFunction = 'doing(&#39;'+id+'&#39;,&#39;'+idDoctor+'&#39;,&#39;'+idStatus+'&#39;,&#39;'+nameStatus+'&#39;,&#39;'+count+'&#39;)';
				onclick = ' onclick="'+doingFunction+'" ';
				// remain = turn-count;				
				htmlAction = '<td id="activeControl">'+btn.bid[0]+id+
						btn.bid[1]+btn.a.call+btn.s.danger+
						btn.bid[2]+onclick+
						btn.bid[3]+'DELAY'+
						btn.bid[4]+'</td>';
			}else if(nameStatus == 'doing'){

				count 			= 0;
				idStatus 		= '4';
				viewFunction 	= 'room(&#39;'+id+'&#39;,&#39;'+roomDoctor+'&#39;)';
				endFunction 	= 'doing(&#39;'+id+'&#39;,&#39;'+idDoctor+'&#39;,&#39;'+idStatus+'&#39;,&#39;'+nameStatus+'&#39;,&#39;'+count+'&#39;)';
				viewOnclick 	= ' onclick="'+viewFunction+'" ';
				endOnclick 		= ' onclick="'+endFunction+'" ';
				// remain = turn-count;
				btnRoom = btn.bid[0]+id+
						btn.bid[1]+btn.a.call+btn.s.info+
						btn.bid[2]+viewOnclick+
						btn.bid[3]+'OPEN'+
						btn.bid[4];
				btnEnd = btn.bid[0]+id+
						btn.bid[1]+btn.a.call+btn.s.danger+
						btn.bid[2]+endOnclick+
						btn.bid[3]+'END'+
						btn.bid[4];

				htmlAction = '<td id="activeControl">'+btnRoom+' '+btnEnd+'</td>';

			}

			return htmlAction;
		}
	//--<> Parse

	//--<> Timer


		function counter(id, valTimer){
			var countCD= valTimer;
			var counter=setInterval(timer, 1000);

			function timer(){
				countCD = countCD-1;
				if (countCD == -1){
					$('#'+id+'.wait_row').text(valTimer);
					clearInterval(counter);
					$('#'+id+'.wait_row').hide();
					getSchedule();
				}else {
					$('#'+id+'.wait_row').text(countCD);
				}
			}
		}
	//--<> Timer