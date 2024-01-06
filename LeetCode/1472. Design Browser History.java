 class Page {
        Page nextPage;
        Page prevPage;

        String url;

        public Page(String url) {
            this.url = url;
        }
}

class BrowserHistory {
    Page currentPage;

    public BrowserHistory(String homepage) {
        this.currentPage = new Page(homepage);
    }

    public void visit(String url) {
        Page visitPage = new Page(url);
        this.currentPage.nextPage = visitPage;
        visitPage.prevPage = this.currentPage;

        this.currentPage = this.currentPage.nextPage;
    }

    public String back(int steps) {
        while(steps-- > 0 &&  this.currentPage.prevPage != null) {
            this.currentPage = this.currentPage.prevPage;
        }

        return this.currentPage.url;
    }

    public String forward(int steps) {
        while(steps-- > 0 && this.currentPage.nextPage != null) {
            this.currentPage = this.currentPage.nextPage;
        }

        return this.currentPage.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
