package suntrix.kmp.firebase.analytics

import suntrix.kmp.firebase.analytics.constants.EventValue
import suntrix.kmp.firebase.analytics.constants.ParamValue

/**
 * Created by Sebastian Owodzin on 29/03/2023
 */
sealed class Event(val eventValue: EventValue) {

    open fun params(): Map<String, Any>? = null

    data class AdImpression(
        val adPlatform: String? = null,
        val adSource: String? = null,
        val adFormat: Map<String, Any>? = null,
        val adUnitName: String? = null,
        val currency: String? = null,
        val value: Double? = null
    ) : Event(EventValue.AD_IMPRESSION) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.AD_PLATFORM to adPlatform,
            ParamValue.AD_SOURCE to adSource,
            ParamValue.AD_FORMAT to adFormat,
            ParamValue.AD_UNIT_NAME to adUnitName,
            ParamValue.CURRENCY to currency,
            ParamValue.VALUE to value
        )
    }

    data class AddPaymentInfo(
        val coupon: String? = null,
        val currency: String? = null,
        val items: Collection<Item>? = null,
        val paymentType: String? = null,
        val value: Double? = null
    ) : Event(EventValue.ADD_PAYMENT_INFO) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.COUPON to coupon,
            ParamValue.CURRENCY to currency,
            ParamValue.ITEMS to items?.params(),
            ParamValue.PAYMENT_TYPE to paymentType,
            ParamValue.VALUE to value
        )
    }

    data class AddShippingInfo(
        val coupon: String? = null,
        val currency: String? = null,
        val items: Collection<Item>? = null,
        val shippingTier: String? = null,
        val value: Double? = null
    ) : Event(EventValue.ADD_SHIPPING_INFO) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.COUPON to coupon,
            ParamValue.CURRENCY to currency,
            ParamValue.ITEMS to items?.params(),
            ParamValue.SHIPPING_TIER to shippingTier,
            ParamValue.VALUE to value
        )
    }

    data class AddToCart(
        val currency: String? = null,
        val items: Collection<Item>? = null,
        val value: Double? = null
    ) : Event(EventValue.ADD_TO_CART) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.CURRENCY to currency,
            ParamValue.ITEMS to items?.params(),
            ParamValue.VALUE to value
        )
    }

    data class AddToWishlist(
        val currency: String? = null,
        val items: Collection<Item>? = null,
        val value: Double? = null
    ) : Event(EventValue.ADD_TO_WISHLIST) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.CURRENCY to currency,
            ParamValue.ITEMS to items?.params(),
            ParamValue.VALUE to value
        )
    }

    object AppOpen : Event(EventValue.APP_OPEN)

    data class BeginCheckout(
        val coupon: String? = null,
        val currency: String? = null,
        val items: Collection<Item>? = null,
        val value: Double? = null
    ) : Event(EventValue.BEGIN_CHECKOUT) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.COUPON to coupon,
            ParamValue.CURRENCY to currency,
            ParamValue.ITEMS to items?.params(),
            ParamValue.VALUE to value
        )
    }

    data class CampaignDetails(
        val source: String,
        val medium: String,
        val campaign: String,
        val term: String? = null,
        val content: String? = null,
        val adNetworkClickID: String? = null,
        val cp1: String? = null,
//        val campaignId: String? = null,
//        val creativeFormat: String? = null,
//        val marketingTactic: String? = null,
//        val sourcePlatform: String? = null
    ) : Event(EventValue.CAMPAIGN_DETAILS) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.SOURCE to source,
            ParamValue.MEDIUM to medium,
            ParamValue.CAMPAIGN to campaign,
            ParamValue.TERM to term,
            ParamValue.CONTENT to content,
            ParamValue.AD_NETWORK_CLICK_ID to adNetworkClickID,
            ParamValue.CP1 to cp1
        )
    }

    data class EarnVirtualCurrency(
        val currencyName: String,
        val value: Double
    ) : Event(EventValue.EARN_VIRTUAL_CURRENCY) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.VIRTUAL_CURRENCY_NAME to currencyName,
            ParamValue.VALUE to value
        )
    }

    data class GenerateLead(
        val currency: String? = null,
        val value: Double? = null
    ) : Event(EventValue.GENERATE_LEAD) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.CURRENCY to currency,
            ParamValue.VALUE to value
        )
    }

    data class JoinGroup(
        val groupId: String
    ) : Event(EventValue.JOIN_GROUP) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.GROUP_ID to groupId
        )
    }

    data class LevelEnd(
        val levelName: String,
        val success: String? = null
    ) : Event(EventValue.LEVEL_END) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.LEVEL_NAME to levelName,
            ParamValue.SUCCESS to success
        )
    }

    data class LevelStart(
        val levelName: String
    ) : Event(EventValue.LEVEL_START) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.LEVEL_NAME to levelName
        )
    }

    data class LevelUp(
        val level: Long,
        val character: String? = null
    ) : Event(EventValue.LEVEL_UP) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.LEVEL to level,
            ParamValue.CHARACTER to character
        )
    }

    data class Login(
        val method: String
    ) : Event(EventValue.LOGIN) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.METHOD to method
        )
    }

    data class PostScore(
        val score: Long,
        val level: Long? = null,
        val character: String? = null
    ) : Event(EventValue.POST_SCORE) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.SCORE to score,
            ParamValue.LEVEL to level,
            ParamValue.CHARACTER to character
        )
    }

    data class Purchase(
        val affiliation: String? = null,
        val coupon: String? = null,
        val currency: String? = null,
        val endDate: String? = null,
        val itemId: String? = null,
        val items: Collection<Item>? = null,
        val shipping: Double? = null,
        val startDate: String? = null,
        val tax: Double? = null,
        val transactionId: Double? = null,
        val value: Double? = null
    ) : Event(EventValue.PURCHASE) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.AFFILIATION to affiliation,
            ParamValue.COUPON to coupon,
            ParamValue.CURRENCY to currency,
            ParamValue.END_DATE to endDate,
            ParamValue.ITEM_ID to itemId,
            ParamValue.ITEMS to items?.params(),
            ParamValue.SHIPPING to shipping,
            ParamValue.START_DATE to startDate,
            ParamValue.TAX to tax,
            ParamValue.TRANSACTION_ID to transactionId,
            ParamValue.VALUE to value
        )
    }

    data class Refund(
        val affiliation: String? = null,
        val coupon: String? = null,
        val currency: String? = null,
        val items: Collection<Item>? = null,
        val shipping: Double? = null,
        val tax: Double? = null,
        val transactionId: Double? = null,
        val value: Double? = null
    ) : Event(EventValue.REFUND) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.AFFILIATION to affiliation,
            ParamValue.COUPON to coupon,
            ParamValue.CURRENCY to currency,
            ParamValue.ITEMS to items?.params(),
            ParamValue.SHIPPING to shipping,
            ParamValue.TAX to tax,
            ParamValue.TRANSACTION_ID to transactionId,
            ParamValue.VALUE to value
        )
    }

    data class RemoveFromCart(
        val currency: String? = null,
        val items: Collection<Item>? = null,
        val value: Double? = null
    ) : Event(EventValue.REMOVE_FROM_CART) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.CURRENCY to currency,
            ParamValue.ITEMS to items?.params(),
            ParamValue.VALUE to value
        )
    }

    data class ScreenView(
        val screenClass: String? = null,
        val screenName: String? = null
    ) : Event(EventValue.SCREEN_VIEW) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.SCREEN_CLASS to screenClass,
            ParamValue.SCREEN_NAME to screenName
        )
    }

    data class Search(
        val searchTerm: String,
        val startDate: String? = null,
        val endDate: String? = null,
        val numberOfNights: Long? = null,
        val numberOfRooms: Long? = null,
        val numberOfPassengers: Long? = null,
        val origin: String? = null,
        val destination: String? = null,
        val travelClass: String? = null
    ) : Event(EventValue.SEARCH) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.SEARCH_TERM to searchTerm,
            ParamValue.START_DATE to startDate,
            ParamValue.END_DATE to endDate,
            ParamValue.NUMBER_OF_NIGHTS to numberOfNights,
            ParamValue.NUMBER_OF_ROOMS to numberOfRooms,
            ParamValue.NUMBER_OF_PASSENGERS to numberOfPassengers,
            ParamValue.ORIGIN to origin,
            ParamValue.DESTINATION to destination,
            ParamValue.TRAVEL_CLASS to travelClass
        )
    }

    data class SelectContent(
        val contentType: String,
        val itemId: String
    ) : Event(EventValue.SELECT_CONTENT) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.CONTENT_TYPE to contentType,
            ParamValue.ITEM_ID to itemId
        )
    }

    data class SelectItem(
        val items: Collection<Item>? = null,
        val itemListId: String? = null,
        val itemListName: String? = null
    ) : Event(EventValue.SELECT_ITEM) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.ITEMS to items?.params(),
            ParamValue.ITEM_LIST_ID to itemListId,
            ParamValue.ITEM_LIST_NAME to itemListName
        )
    }

    data class SelectPromotion(
        val creativeName: String? = null,
        val creativeSlot: String? = null,
        val items: Collection<Item>? = null,
        val locationId: String? = null,
        val promotionId: String? = null,
        val promotionName: String? = null
    ) : Event(EventValue.SELECT_PROMOTION) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.CREATIVE_NAME to creativeName,
            ParamValue.CREATIVE_SLOT to creativeSlot,
            ParamValue.ITEMS to items?.params(),
            ParamValue.LOCATION_ID to locationId,
            ParamValue.PROMOTION_ID to promotionId,
            ParamValue.PROMOTION_NAME to promotionName
        )
    }

    data class Share(
        val contentType: String,
        val itemId: String,
        val method: String
    ) : Event(EventValue.SHARE) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.CONTENT_TYPE to contentType,
            ParamValue.ITEM_ID to itemId,
            ParamValue.METHOD to method
        )
    }

    data class SignUp(
        val method: String
    ) : Event(EventValue.SIGN_UP) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.METHOD to method
        )
    }

    data class SpendVirtualCurrency(
        val itemName: String,
        val virtualCurrencyName: String,
        val value: Double
    ) : Event(EventValue.SPEND_VIRTUAL_CURRENCY) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.ITEM_NAME to itemName,
            ParamValue.VIRTUAL_CURRENCY_NAME to virtualCurrencyName,
            ParamValue.VALUE to value
        )
    }

    object TutorialBegin : Event(EventValue.TUTORIAL_BEGIN)

    object TutorialComplete : Event(EventValue.TUTORIAL_COMPLETE)

    data class UnlockAchievement(
        val achievementId: String
    ) : Event(EventValue.UNLOCK_ACHIEVEMENT) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.ACHIEVEMENT_ID to achievementId
        )
    }

    data class ViewCart(
        val currency: String? = null,
        val items: Collection<Item>? = null,
        val value: Double? = null
    ) : Event(EventValue.VIEW_CART) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.CURRENCY to currency,
            ParamValue.ITEMS to items?.params(),
            ParamValue.VALUE to value
        )
    }

    data class ViewItem(
        val currency: String? = null,
        val items: Collection<Item>? = null,
        val value: Double? = null
    ) : Event(EventValue.VIEW_ITEM) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.CURRENCY to currency,
            ParamValue.ITEMS to items?.params(),
            ParamValue.VALUE to value
        )
    }

    data class ViewItemList(
        val items: Collection<Item>? = null,
        val itemListId: String? = null,
        val itemListName: String? = null
    ) : Event(EventValue.VIEW_ITEM_LIST) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.ITEMS to items?.params(),
            ParamValue.ITEM_LIST_ID to itemListId,
            ParamValue.ITEM_LIST_NAME to itemListName
        )
    }

    data class ViewPromotion(
        val creativeName: String? = null,
        val creativeSlot: String? = null,
        val items: Collection<Item>? = null,
        val locationId: String? = null,
        val promotionId: String? = null,
        val promotionName: String? = null
    ) : Event(EventValue.VIEW_PROMOTION) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.CREATIVE_NAME to creativeName,
            ParamValue.CREATIVE_SLOT to creativeSlot,
            ParamValue.ITEMS to items?.params(),
            ParamValue.LOCATION_ID to locationId,
            ParamValue.PROMOTION_ID to promotionId,
            ParamValue.PROMOTION_NAME to promotionName
        )
    }

    data class ViewSearchResults(
        val searchTerm: String
    ) : Event(EventValue.VIEW_SEARCH_RESULTS) {

        override fun params(): Map<String, Any> = buildParams(
            ParamValue.SEARCH_TERM to searchTerm
        )
    }
}

data class Item(
    val name: String,
    val category: String
) {
    fun params(): Map<String, Any> = buildParams(
        ParamValue.ITEM_NAME to name,
        ParamValue.ITEM_CATEGORY to category
    )
}

fun Collection<Item>.params() = map { it.params() }

internal fun buildParams(vararg pairs: Pair<ParamValue, Any?>): Map<String, Any> =
    pairs.mapNotNull { it.second?.run { it.first.nativeValue() to this } }.toMap()