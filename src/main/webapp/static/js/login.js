/**
 * 
 */

function CheckEmail(formNode, inputNode) {
	this.formNode = document.querySelector('#' + formNode);
	this.inputNode = document.querySelector('#' + inputNode);
	this.checkEmail = function() {
		const regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		const email = this.inputNode.value;
		if (regExp.test(email)) {
			this.formNode.submit();
			console.log('전송됨');
			return true;
		} else {
			const error = document.querySelectorAll('.error');
			error.forEach((v) => {
				v.remove();
			})
			const node = "<div class='error'>이메일을 제대로 작성했는지 확인해주세요.</div>";
			this.inputNode.parentElement.insertAdjacentHTML("afterend", node);
			console.log('전송실패');
			return false;
		}
	}

}
const check = new CheckEmail("login", "email");