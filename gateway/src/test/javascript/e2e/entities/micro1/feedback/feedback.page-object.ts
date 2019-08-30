import { element, by, ElementFinder } from 'protractor';

export class FeedbackComponentsPage {
    createButton = element(by.id('jh-create-entity'));
    title = element.all(by.css('jhi-feedback div h2#page-heading span')).first();

    async clickOnCreateButton() {
        await this.createButton.click();
    }

    async getTitle() {
        return this.title.getText();
    }
}

export class FeedbackUpdatePage {
    pageTitle = element(by.id('jhi-feedback-heading'));
    saveButton = element(by.id('save-entity'));
    cancelButton = element(by.id('cancel-save'));
    sportNameInput = element(by.id('field_sportName'));
    creatorNameInput = element(by.id('field_creatorName'));
    rateInput = element(by.id('field_rate'));
    sportSelect = element(by.id('field_sport'));
    feedsportSelect = element(by.id('field_feedsport'));

    async getPageTitle() {
        return this.pageTitle.getText();
    }

    async setSportNameInput(sportName) {
        await this.sportNameInput.sendKeys(sportName);
    }

    async getSportNameInput() {
        return this.sportNameInput.getAttribute('value');
    }

    async setCreatorNameInput(creatorName) {
        await this.creatorNameInput.sendKeys(creatorName);
    }

    async getCreatorNameInput() {
        return this.creatorNameInput.getAttribute('value');
    }

    async setRateInput(rate) {
        await this.rateInput.sendKeys(rate);
    }

    async getRateInput() {
        return this.rateInput.getAttribute('value');
    }

    async sportSelectLastOption() {
        await this.sportSelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async sportSelectOption(option) {
        await this.sportSelect.sendKeys(option);
    }

    getSportSelect(): ElementFinder {
        return this.sportSelect;
    }

    async getSportSelectedOption() {
        return this.sportSelect.element(by.css('option:checked')).getText();
    }

    async feedsportSelectLastOption() {
        await this.feedsportSelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async feedsportSelectOption(option) {
        await this.feedsportSelect.sendKeys(option);
    }

    getFeedsportSelect(): ElementFinder {
        return this.feedsportSelect;
    }

    async getFeedsportSelectedOption() {
        return this.feedsportSelect.element(by.css('option:checked')).getText();
    }

    async save() {
        await this.saveButton.click();
    }

    async cancel() {
        await this.cancelButton.click();
    }

    getSaveButton(): ElementFinder {
        return this.saveButton;
    }
}
