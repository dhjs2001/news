export default class newsSection {
    constructor(fetchUrl) {
		this.fetchUrl = fetchUrl
	
    }

    init(fnNewsListTemplate, contentNode) {
		this.fetchData();
		this.fnNewsListTemplate = fnNewsListTemplate;
		this.contentNode = contentNode;
		this.pageNumber = 0;
    }

	fetchData(url){
		fetch(this.fetchUrl).then((res)=>{
			return res.json();
		}).then(result =>{
			this.newsList = result;
			this.makeNewsContent();
		})
	}
	
	makeNewsContent(){
		if(this.pageNumber > this.newsList.length -1){
			this.pageNumber = this.newsList.length -1;
		}else if(this.pageNumber < 0){
			this.pageNumber = 0;
		}
		this.contentNode.innerHTML = this.fnNewsListTemplate(this.newsList[this.pageNumber]);
	}
	leftButtonAction(){
		this.pageNumber -= 1;
		this.makeNewsContent();
	}
	rightButtonAction(){
		this.pageNumber += 1;
		this.makeNewsContent();
	}
	

}
