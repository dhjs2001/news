import newsSection from './newsSection.js'
import { fnNewsListTemplate } from '../templates/news.js'

document.addEventListener("DOMContentLoaded", () => {
	const url = "/static/data/newslist.json";
	const contentNode = document.querySelector('.content');
	const news = new newsSection(url);
	news.init(fnNewsListTemplate, contentNode);
	const left = document.querySelector('.left');
	left.onclick = ()=>{news.leftButtonAction()};
	const right= document.querySelector('.right');
	right.onclick = ()=>{news.rightButtonAction()};
});

