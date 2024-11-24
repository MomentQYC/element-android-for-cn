/*
 * Copyright 2022-2024 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 * Please see LICENSE in the repository root for full details.
 */

package im.vector.app.config

import kotlin.time.Duration.Companion.days

/**
 * Set of flags to configure the application.
 */
object Config {
    /**
     * Flag to allow external UnifiedPush distributors to be chosen by the user.
     *
     * Set to true to allow any available external UnifiedPush distributor to be chosen by the user.
     * - For Gplay variant it means that FCM will be used by default, but user can choose another UnifiedPush distributor;
     * - For F-Droid variant, it means that background polling will be used by default, but user can choose another UnifiedPush distributor.
     *
     * Set to false to prevent usage of external UnifiedPush distributors.
     * - For Gplay variant it means that only FCM will be used;
     * - For F-Droid variant, it means that only background polling will be available to the user.
     *
     * *Note*: When the app is already installed on users' phone:
     * - Changing the value from `false` to `true` will let the user be able to select an external UnifiedPush distributor;
     * - Changing the value from `true` to `false` will force the app to return to the background sync / Firebase Push.
     */
    const val ALLOW_EXTERNAL_UNIFIED_PUSH_DISTRIBUTORS = true

    const val ENABLE_LOCATION_SHARING = true
    const val LOCATION_MAP_TILER_KEY = "fU3vlMsMn4Jb6dnEIFsx"

    /**
     * Whether to read the `io.element.functional_members` state event
     * and exclude any service members when computing a room's name and avatar.
     */
    const val SUPPORT_FUNCTIONAL_MEMBERS = true

    /**
     * The maximum length of voice messages in milliseconds.
     */
    const val VOICE_MESSAGE_LIMIT_MS = 120_000L

    /**
     * The strategy for sharing device keys.
     */
    val KEY_SHARING_STRATEGY = KeySharingStrategy.WhenTyping

    /**
     * The onboarding flow.
     */
    val ONBOARDING_VARIANT = OnboardingVariant.FTUE_AUTH

    /**
     * If set, MSC3086 asserted identity messages sent on VoIP calls will cause the call to appear in the room corresponding to the asserted identity.
     * This *must* only be set in trusted environments.
     */
    const val HANDLE_CALL_ASSERTED_IDENTITY_EVENTS = false

    const val LOW_PRIVACY_LOG_ENABLE = false
    const val ENABLE_STRICT_MODE_LOGS = false

    /**
     * The analytics configuration to use for the Debug build type.
     * Can be disabled by providing Analytics.Disabled
     */
    val DEBUG_ANALYTICS_CONFIG = Analytics.Enabled(
            postHogHost = "https://app.posthog.com",
            postHogApiKey = "phc_lWFCKxEjO5k2uYZMxOyLcIVs4FLtXnrmzwXCN1JdvOR",
            policyLink = "https://www.yatserver.com/terms-of-service-and-privacy-policy/",
            sentryDSN = "https://78bf8a9f9619436c96cdafea9f949ad0@bugtracking.whimsies.org/9",
            sentryEnvironment = "DEBUG"
    )

    /**
     * The analytics configuration to use for the Release build type.
     * Can be disabled by providing Analytics.Disabled
     */
    val RELEASE_ANALYTICS_CONFIG = Analytics.Enabled(
            postHogHost = "https://app.posthog.com",
            postHogApiKey = "phc_lWFCKxEjO5k2uYZMxOyLcIVs4FLtXnrmzwXCN1JdvOR",
            policyLink = "https://www.yatserver.com/terms-of-service-and-privacy-policy/",
            sentryDSN = "https://https://78bf8a9f9619436c96cdafea9f949ad0@bugtracking.whimsies.org/9",
            sentryEnvironment = "RELEASE"
    )

    /**
     * The analytics configuration to use for the Nightly build type.
     * Can be disabled by providing Analytics.Disabled
     */
    val NIGHTLY_ANALYTICS_CONFIG = RELEASE_ANALYTICS_CONFIG.copy(sentryEnvironment = "NIGHTLY")
    val RELEASE_R_ANALYTICS_CONFIG = RELEASE_ANALYTICS_CONFIG.copy(sentryEnvironment = "RELEASE-R")
    val ER_NIGHTLY_ANALYTICS_CONFIG = RELEASE_ANALYTICS_CONFIG.copy(sentryEnvironment = "element-r")
    val ER_DEBUG_ANALYTICS_CONFIG = DEBUG_ANALYTICS_CONFIG.copy(sentryEnvironment = "element-r")

    val SHOW_UNVERIFIED_SESSIONS_ALERT_AFTER_MILLIS = 7.days.inWholeMilliseconds // 1 Week
}
