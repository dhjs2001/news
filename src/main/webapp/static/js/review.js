/**
 * 
 */
//review 평점 별 채우기
function fillStars(){
	const averageRateNode = document.querySelector('.average-rate');
	const maxRateNode = document.querySelector('.max-rate');
	const filledStarsNode = document.querySelector('.filled-stars');
	const emptyStarsNode = document.querySelector('.empty-stars');
	const filledStarsCloneNode = filledStarsNode.cloneNode(true);
	
	const fillNumber = Math.floor(averageRateNode.innerText);
	const imcompleteStarNumber = Number((averageRateNode.innerText % 1).toFixed(2));
	const emptyNumber = maxRateNode.innerText -fillNumber;
	
	
	const filledStars = filledStarsNode.innerText.repeat(fillNumber);
	const emptyStars = emptyStarsNode.innerText.repeat(emptyNumber);
	
	filledStarsNode.innerText = filledStars;
	emptyStarsNode.innerText = emptyStars;
	
	
	filledStarsCloneNode.style = 'position:absolute; top:0; left:0; overflow:hidden'
	
	emptyStarsNode.append(filledStarsCloneNode);
	let width = window.getComputedStyle(filledStarsCloneNode).getPropertyValue('width');
	width = width.replace("px","");
	filledStarsCloneNode.style.width = width * imcompleteStarNumber + "px";
}

// 로드가 끝나면 title 슬라이더에 animtaion 클래스 추가, 펼쳐보기 크기 조절
window.onload = function() {
	fillStars();
}
