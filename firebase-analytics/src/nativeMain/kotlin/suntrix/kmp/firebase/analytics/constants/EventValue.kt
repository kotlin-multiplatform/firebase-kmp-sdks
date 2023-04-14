package suntrix.kmp.firebase.analytics.constants

import native.FirebaseAnalytics.*

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
actual enum class EventValue(private val nativeValue: String) {
    AD_IMPRESSION(kFIREventAdImpression!!),
    ADD_PAYMENT_INFO(kFIREventAddPaymentInfo!!),
    ADD_SHIPPING_INFO(kFIREventAddShippingInfo!!),
    ADD_TO_CART(kFIREventAddToCart!!),
    ADD_TO_WISHLIST(kFIREventAddToWishlist!!),
    APP_OPEN(kFIREventAppOpen!!),
    BEGIN_CHECKOUT(kFIREventBeginCheckout!!),
    CAMPAIGN_DETAILS(kFIREventCampaignDetails!!),
    EARN_VIRTUAL_CURRENCY(kFIREventEarnVirtualCurrency!!),
    GENERATE_LEAD(kFIREventGenerateLead!!),
    JOIN_GROUP(kFIREventJoinGroup!!),
    LEVEL_END(kFIREventLevelEnd!!),
    LEVEL_START(kFIREventLevelStart!!),
    LEVEL_UP(kFIREventLevelUp!!),
    LOGIN(kFIREventLogin!!),
    POST_SCORE(kFIREventPostScore!!),
    PURCHASE(kFIREventPurchase!!),
    REFUND(kFIREventRefund!!),
    REMOVE_FROM_CART(kFIREventRemoveFromCart!!),
    SCREEN_VIEW(kFIREventScreenView!!),
    SEARCH(kFIREventSearch!!),
    SELECT_CONTENT(kFIREventSelectContent!!),
    SELECT_ITEM(kFIREventSelectItem!!),
    SELECT_PROMOTION(kFIREventSelectPromotion!!),
    SHARE(kFIREventShare!!),
    SIGN_UP(kFIREventSignUp!!),
    SPEND_VIRTUAL_CURRENCY(kFIREventSpendVirtualCurrency!!),
    TUTORIAL_BEGIN(kFIREventTutorialBegin!!),
    TUTORIAL_COMPLETE(kFIREventTutorialComplete!!),
    UNLOCK_ACHIEVEMENT(kFIREventUnlockAchievement!!),
    VIEW_CART(kFIREventViewCart!!),
    VIEW_ITEM(kFIREventViewItem!!),
    VIEW_ITEM_LIST(kFIREventViewItemList!!),
    VIEW_PROMOTION(kFIREventViewPromotion!!),
    VIEW_SEARCH_RESULTS(kFIREventViewSearchResults!!);

    actual fun nativeValue() = nativeValue
}