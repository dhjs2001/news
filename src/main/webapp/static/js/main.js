/**
 * 
 */

// Category 클릭시 초록색 밑줄 추가

const categoryUl = document.querySelector("ul");
categoryUl.onclick = function(evt) {
	const categoryLi = document.querySelectorAll('ul > li');
	if (evt.target.tagName == "LI") {
		for (i = 0; i < categoryLi.length; i++) {
			categoryLi[i].classList.remove("clicked-list");
		}
		evt.target.classList.add("clicked-list");
	}
}



// 프로모션 슬라이드

const slide = document.querySelector('.promotion-container');
const clone = slide.firstElementChild.cloneNode(true);
slide.appendChild(clone);
const length = slide.childElementCount;
slide.style.width = length * 100 + "%";
let count = 1;
function promotionAction() {
	setTimeout(function() {
		if (count != length) {
			if (count == 1) {
				slide.classList.add("animation");
			}
			slide.style.left = -count * 100 + "%";
			count += 1;

		} else {
			slide.classList.remove("animation");
			slide.style.left = 0;
			count = 1;
		}
		promotionAction();
	}, 3000);

}
promotionAction();



// 더 보기 클릭시 카테고리 아이디 확인 용 객체
const moreStandard = {
	start: 0,
	currentId: 1,
	allItemsNumber: 0,

	getStart: function() { return this.start; },
	setStart: function(value) { this.start = value; },
	getCurrentId: function() { return this.currentId; },
	setCurrentId: function(value) { this.currentId = value; },
	getAllItemsNumber: function() { return this.allItemsNumber; },
	setAllItemsNumber: function(value) { this.allItemsNumber = value; },
};



// ajax를 통해 category에 따른 product 목록 가져오기
function ajax(id, start, moreStandard) {
	return new Promise((resolv, reject) => {
		const oReq = new XMLHttpRequest();
		oReq.addEventListener("load", function() {
			const context = JSON.parse(this.responseText);
			console.log(context);
			moreStandard.setCurrentId(id);
			resolv(context);
		});
		oReq.open("GET", "/api/products/" + id + "/" + start);
		oReq.send();
	});
}

//더 보기 클릭 시 아이템 더 가져오기
const more = document.querySelector('.more');
more.addEventListener("click", function() {
	getItems(moreStandard.currentId, moreStandard);
})

function getItems(id, moreStandard) {
	if (id == moreStandard.getCurrentId()) {
		const addStartNumber = 4;
		const start = moreStandard.getStart() + addStartNumber;
		moreStandard.setStart(start);
		console.log(moreStandard.getStart())
		ajax(id, moreStandard.getStart(), moreStandard).then((context) => deploy(context, 1, moreStandard));
	} else {
		console.log(moreStandard.getStart())
		moreStandard.setCurrentId(id);
		moreStandard.setStart(0);
		ajax(id, moreStandard.getStart(), moreStandard).then((context) => deploy(context, 0, moreStandard));
	}
}

// 아이템 배치하기
function deploy(context, isSame, moreStandard) {
	const source = document.getElementById("product-template").innerHTML;
	const template = Handlebars.compile(source);
	const productList1 = document.querySelector(".product-list1");
	const productList2 = document.querySelector(".product-list2");
	const length = context.length;
	let html1 = '';
	let html2 = '';
	const AllItemsNumber = moreStandard.getAllItemsNumber();
	if (AllItemsNumber != length) {
		moreStandard.setAllItemsNumber(length);
	}
	document.querySelector(".item-length").innerText = length;
	if (isSame == 1) {
		context.product.forEach((v, i) => {

			if (i % 2 != 0) {
				html1 += template(v);
			} else {
				html2 += template(v);
			}
		});
		productList1.innerHTML += html1;
		productList2.innerHTML += html2;
		const more = document.querySelector('.more');
		const currentItemsNumber = document.querySelectorAll('.product').length;
		if (currentItemsNumber == moreStandard.getAllItemsNumber()) {
			more.hidden = true;
		}
	} else {
		if (more.hidden) {
			more.hidden = false;
		}
		context.product.forEach((v, i) => {

			if (i % 2 != 0) {
				html1 += template(v);
			} else {
				html2 += template(v);
			}
		});
		productList1.innerHTML = html1;
		productList2.innerHTML = html2;
	}
}

// 처음 목록 가져오기
getItems(0, moreStandard);


//카테고리 마다 클릭 이벤트 추가
// 전시 1, 뮤지컬 2, 콘서트 3, 클래식 4, 연극 5
//카테고리 목록
const category = { "전체": 0, "전시": 1, "뮤지컬": 2, "콘서트": 3, "클래식": 4, "연극": 5 };

//카테고리에 이벤트 추가 함수
function addEventOnCategory(category) {
	for (const i in category) {
		const categoryId = category[i];
		const categoryElement = document.querySelector('.category' + categoryId);
		categoryElement.addEventListener("click", function() {
			getItems(categoryId, moreStandard);
		});
	}
}


//카테고리에 이벤트 추가
addEventOnCategory(category);



/*
function deployItems() {
	const items = document.querySelectorAll('.product');
	const offsetWidth = items[0].offsetWidth;
	let totalWidth = items[0].parentElement.offsetWidth;
	let margin = (totalWidth - (offsetWidth * 2)) / 3;
	let left = offsetWidth + margin
	let firstLineTop = 5;
	let secondLineTop = 5;
	let itemNumber = 1;
	items.forEach(function(v) {
		if (itemNumber % 2 == 0) {
			v.style.position = 'absolute';
			v.style.left = left + margin + "px";
			v.style.top = secondLineTop + "px";
			secondLineTop += v.offsetHeight + margin;
			itemNumber++;
		} else {
			v.style.position = 'absolute';
			v.style.left = margin + "px";
			v.style.top = firstLineTop + "px";
			firstLineTop += v.offsetHeight + margin;
			itemNumber++;

		}
	});
	const footer = document.querySelector('footer');
	const headerHeight = document.querySelector('header').offsetHeight;
	let footerTop = 0;
	footer.style.position = 'absolute';
	footer.style.left = 0;
	footer.style.right = 0;
	if (firstLineTop > secondLineTop) {
		footerTop = headerHeight + firstLineTop;
		footer.style.top = footerTop + "px";
	} else {
		footerTop = headerHeight + secondLineTop;
		footer.style.top = footerTop + "px";
	}
}
*/

//브라우저 화면 크기 변경시마다 재배치
//window.addEventListener("resize", () => deployItems());
