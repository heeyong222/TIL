window.onload = function() {
	document.querySelector('#btn-add').addEventListener('click' , function(e) {
		var listDiv = document.querySelector('#poll-answer-list');
		var divEl = document.createElement('div'); // <div></div>
	    divEl.setAttribute('class', 'poll-answer-item'); // <div class="poll-answer-item"></div>
	    var inputEl = document.createElement('input');
	    inputEl.setAttribute('type', 'text');
	    inputEl.setAttribute('name', 'answer');
	    var buttonEl = document.createElement('button');
	    buttonEl.setAttribute('type', 'button');
	    buttonEl.setAttribute('class', 'button');
	    buttonEl.addEventListener('click', function (e) {
	      var parent = this.parentNode;
	      listDiv.removeChild(parent);
	    });
	    buttonEl.appendChild(document.createTextNode('삭제'));

	    divEl.appendChild(inputEl);
	    divEl.appendChild(buttonEl);
	    listDiv.appendChild(divEl);
	});
	
	document.querySelector('#btn-make').addEventListener('click', function(e) {
		var question = document.getElementById("question");
		if(!question.value){
			alert('질문 내용을 입력하세요');
			question.focus();
			return
		}
		
		var answer = document.getElementsByName('answer');
		for (var i = 0; i < answer.length; i++) {
			if(!answer[i].value){
				alert('답변 항목 입력');
				answer[i].focus();
				return
			}
		}
		
		var answerArr=[];
		for (var i = 0; i < answer.length; i++) {
			answerArr.push(answer[i].value);
		}
		
		//localStorage에 저장
		localStorage.setItem('question', question.value);
		//JSON.stringify()   : JavaScript의 객체를 JSON 형식의 문자열로 변경하는 기능 
		localStorage.setItem('answer', JSON.stringify(answerArr));
		
		
		alert('투표를 생성합니다.')
		//새창을 연 page를 새로 load하기
		opener.location.reload();
		
		//새창을 닫기 
		self.close();
	});
}






