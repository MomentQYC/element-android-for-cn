/*
 * Copyright 2022-2024 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 * Please see LICENSE in the repository root for full details.
 */

package im.vector.lib.core.utils.compat

import android.os.Build

fun <E> MutableCollection<E>.removeIfCompat(predicate: (E) -> Boolean) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        removeIf(predicate)
    } else {
        removeAll(filter(predicate).toSet())
    }
}
