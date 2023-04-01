package suntrix.kmp.firebase.analytics.constants

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
expect enum class EventValue {
    AD_IMPRESSION,
    ADD_PAYMENT_INFO,
    ADD_SHIPPING_INFO,
    ADD_TO_CART,
    ADD_TO_WISHLIST,
    APP_OPEN,
    BEGIN_CHECKOUT,
    CAMPAIGN_DETAILS,
    EARN_VIRTUAL_CURRENCY,
    GENERATE_LEAD,
    JOIN_GROUP,
    LEVEL_END,
    LEVEL_START,
    LEVEL_UP,
    LOGIN,
    POST_SCORE,
    PURCHASE,
    REFUND,
    REMOVE_FROM_CART,
    SCREEN_VIEW,
    SEARCH,
    SELECT_CONTENT,
    SELECT_ITEM,
    SELECT_PROMOTION,
    SHARE,
    SIGN_UP,
    SPEND_VIRTUAL_CURRENCY,
    TUTORIAL_BEGIN,
    TUTORIAL_COMPLETE,
    UNLOCK_ACHIEVEMENT,
    VIEW_CART,
    VIEW_ITEM,
    VIEW_ITEM_LIST,
    VIEW_PROMOTION,
    VIEW_SEARCH_RESULTS;

    fun nativeValue(): String
}