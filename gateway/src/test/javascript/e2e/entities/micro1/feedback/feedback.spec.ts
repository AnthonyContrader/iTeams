import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { FeedbackComponentsPage, FeedbackUpdatePage } from './feedback.page-object';

describe('Feedback e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let feedbackUpdatePage: FeedbackUpdatePage;
    let feedbackComponentsPage: FeedbackComponentsPage;

    beforeAll(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load Feedbacks', async () => {
        await navBarPage.goToEntity('feedback');
        feedbackComponentsPage = new FeedbackComponentsPage();
        expect(await feedbackComponentsPage.getTitle()).toMatch(/gatewayApp.micro1Feedback.home.title/);
    });

    it('should load create Feedback page', async () => {
        await feedbackComponentsPage.clickOnCreateButton();
        feedbackUpdatePage = new FeedbackUpdatePage();
        expect(await feedbackUpdatePage.getPageTitle()).toMatch(/gatewayApp.micro1Feedback.home.createOrEditLabel/);
        await feedbackUpdatePage.cancel();
    });

    it('should create and save Feedbacks', async () => {
        await feedbackComponentsPage.clickOnCreateButton();
        await feedbackUpdatePage.setCreatorNameInput('creatorName');
        expect(await feedbackUpdatePage.getCreatorNameInput()).toMatch('creatorName');
        await feedbackUpdatePage.setRateInput('5');
        expect(await feedbackUpdatePage.getRateInput()).toMatch('5');
        await feedbackUpdatePage.sportSelectLastOption();
        await feedbackUpdatePage.save();
        expect(await feedbackUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(async () => {
        await navBarPage.autoSignOut();
    });
});
