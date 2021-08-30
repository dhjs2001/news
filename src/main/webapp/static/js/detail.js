/**
 * 
 */



//슬라이더
let sliderLength = 0;
let currentLocation = 0;
let changedLocationNumber = 0;
function slider() {
	const slider = document.querySelector('.title-img-container');
	const children = slider.children;
	sliderLength = children.length;


	for (let i in [1, 2]) {
		for (let j = 0; j < sliderLength; j++) {
			const node = children[j].cloneNode(true);
			slider.appendChild(node);
		}
	}
	slider.style.left = -sliderLength * 100 + "%";
	currentLocation = -sliderLength;
	sliderItemsSetNumber = 3;
	const totalSliderLength = sliderLength * sliderItemsSetNumber;
	slider.style.width = 100 * totalSliderLength + "%";
}

function moveSlider(number) {
	if (number == 1 || number == -1) {
		const slider = document.querySelector('.title-img-container');
		currentLocation += number;
		changedLocationNumber += number;
		slider.style.left = currentLocation * 100 + '%';
		getPage(number);
		if (changedLocationNumber == sliderLength || changedLocationNumber == -sliderLength) {
			const promise = new Promise((resolv, reject) => {
				setTimeout(() => {
					slider.classList.remove('animation');
					slider.style.left = -sliderLength * 100 + '%';
					currentLocation = -sliderLength;
					changedLocationNumber = 0;
					getPage(0);
					resolv();
				}, 500);
			});
			promise.then(() => {
				setTimeout(() => {
					slider.classList.add('animation');
				}, 100);
			});
		}
	}

}
// 현재 페이지
let currentPage = 1;
function getPage(number) {
	const currentPageNode = document.querySelector('.current-page-number');
	const totalPage = document.querySelector('.total-page-number').innerText;
	//페이지 오른쪽으로 이동
	if (number == -1) {
		if (currentPage != totalPage) {
			currentPage += 1;
		} else {
			currentPage = 1
		}
		//페이지 왼쪽으로 이동
	} else if (number == 1) {
		if (currentPage == 1) {
			currentPage = totalPage;
		} else {
			currentPage -= 1;
		}
		//초기화		
	} else if (number == 0) {
		currentPage = 1;
	} else {
		console.log('getPage 오류: 1, 0, -1을 제외한 인자값');
		return false;
	}
	currentPageNode.innerText = currentPage;
}
// 슬라이더 이동 이벤트 추가
let leftSlideMover = document.querySelector('.left-mover');
leftSlideMover.addEventListener("click", () => {
	moveSlider(1);
})
let rightSlideMover = document.querySelector('.right-mover');
rightSlideMover.addEventListener("click", () => {
	moveSlider(-1);
})

//슬라이더 페이지가 하나인지 확인
function pageNumberCheck() {
	const pageNumber = document.querySelector('.total-page-number').innerText;
	if (pageNumber != 1) {
		return true;
	} else {
		const titleImgPage = document.querySelector('.title-img-page');
		const leftMover = document.querySelector('.left-mover');
		const rightMover = document.querySelector('.right-mover');
		titleImgPage.hidden = true;
		leftMover.hidden = true;
		rightMover.hidden = true;
		return false;
	}


}







//펼쳐보기
let bigHeight = 0;
function spreader(node, bigHeight) {
	const smallHeight = 40
	const height = node.offsetHeight;
	const textNode = document.querySelector('.more-description');
	if (height != smallHeight) {
		node.style.height = smallHeight + 'px';
		textNode.innerHTML = '펼쳐보기 <span>v</span>';

	} else {
		node.style.height = bigHeight + 'px';
		textNode.innerHTML = '접기 <span>∧</span>';
	}
}
//펼쳐진 상태의 높이 bigHeight 받아오기
function getBigHeight(node) {
	node.style.height = '';
	const bigHeight = node.offsetHeight;
	return bigHeight;
}

//펼쳐보기 이벤트리스너 추가
const spread = document.querySelector('.more-description');
spread.addEventListener("click", () => {
	const node = document.querySelector('.product-description-detail');
	spreader(node, bigHeight);
});


window.addEventListener("resize", () => {
	const node = document.querySelector('.product-description-detail');
	bigHeight = getBigHeight(node);
	spreader(node, bigHeight);
});





//event 내용 끝에 쉼표 지우기
const event = document.getElementById('event');
const eventContent = event.innerText.substr(0, event.innerText.length - 2);
event.innerText = eventContent;


//review 평점 별 채우기
function fillStars() {
	const averageRateNode = document.querySelector('.average-rate');
	const maxRateNode = document.querySelector('.max-rate');
	const filledStarsNode = document.querySelector('.filled-stars');
	const emptyStarsNode = document.querySelector('.empty-stars');
	const filledStarsCloneNode = filledStarsNode.cloneNode(true);

	const fillNumber = Math.floor(averageRateNode.innerText);
	const imcompleteStarNumber = Number((averageRateNode.innerText % 1).toFixed(2));
	const emptyNumber = maxRateNode.innerText - fillNumber;


	const filledStars = filledStarsNode.innerText.repeat(fillNumber);
	const emptyStars = emptyStarsNode.innerText.repeat(emptyNumber);

	filledStarsNode.innerText = filledStars;
	emptyStarsNode.innerText = emptyStars;


	filledStarsCloneNode.style = 'position:absolute; top:0; left:0; overflow:hidden'

	emptyStarsNode.append(filledStarsCloneNode);
	let width = window.getComputedStyle(filledStarsCloneNode).getPropertyValue('width');
	width = width.replace("px", "");
	filledStarsCloneNode.style.width = width * imcompleteStarNumber + "px";
}

// 리뷰 없으면 더보기 지우기
function reviewNumberCheck() {
	const number = document.querySelectorAll('.review').length;
	if (number == 0) {
		const moreReviewNode = document.querySelector(".more-review");
		moreReviewNode.hidden = true;
	}

}
//상세정보 오시는 길 받아오기
//상세정보 : 0, 오시는 길 : 1
function ajax(number) {
	const xhr = new XMLHttpRequest();
	let id = document.location.href.split("?")[0].split("/");
	id = id[id.length - 1];
	console.log(id);

	if (number == 0) {
		xhr.addEventListener("load", () => {
			const node = document.querySelector('.detail-or-map');
			const source = document.querySelector('#detail-info').innerHTML;
			const template = Handlebars.compile(source);
			const result = JSON.parse(xhr.responseText);
			const html = template(result[0]);
			node.innerHTML = html;
		});
		xhr.open("get", "/api/detail/detailInfo/" + id);
		xhr.send();

	} else if (number == 1) {
		xhr.addEventListener("load", () => {
			const node = document.querySelector('.detail-or-map');
			const source = document.querySelector('#road-map').innerHTML;
			const template = Handlebars.compile(source);
			const result = JSON.parse(xhr.responseText);
			const html = template(result[0]);
			node.innerHTML = html;
			console.log(html);
		});
		xhr.open("get","/api/detail/roadMap/"+ id);
		xhr.send();
	} else {
		console.log("오류: ajax 입력 값이 0 또는 1이 아닙니다.");
	}
}
// 상세정보, 오시는길 클릭 할 때 색 넣고 밑줄 긋기
function clickedCategory(node) {
	const nodes = document.querySelectorAll('.detail-and-map-tab > li');
	const style = 'color:green; border-bottom:solid 1px green';

	nodes.forEach((v) => {
		v.style = '';
	});

	node.style = style;
}
// 상세정보, 오시는길 이벤트 추가

function addEventOnCategory() {
	const detailInfo = document.querySelectorAll('.detail-and-map-tab > li');
	detailInfo.forEach((v, i)=>{
		v.addEventListener("click",(e)=>{
			clickedCategory(e.target);
			ajax(i);
		});
	});
}




// 로드가 끝나면 title 슬라이더에 animtaion 클래스 추가, 펼쳐보기 크기 조절
window.onload = function() {
	if (pageNumberCheck()) {
		slider();
		getPage(0);
	}
	const sliders = document.querySelector('.title-img-container');
	setTimeout(() => { sliders.classList.add('animation') }, 0);
	const node = document.querySelector('.product-description-detail');
	bigHeight = getBigHeight(node);
	spreader(node, bigHeight);
	fillStars();
	reviewNumberCheck();
	ajax(0);
	const detailAndMapTab = document.querySelector('.detail-and-map-tab > li');
	clickedCategory(detailAndMapTab);
	addEventOnCategory();
}

