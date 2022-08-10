/*
 * Copyright (c) 2022 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.matrix.android.sdk.internal.crypto.keysbackup.algorithm

import org.matrix.android.sdk.api.crypto.MXCRYPTO_ALGORITHM_AES_256_BACKUP
import org.matrix.android.sdk.api.crypto.MXCRYPTO_ALGORITHM_CURVE_25519_BACKUP
import org.matrix.android.sdk.api.session.crypto.keysbackup.KeysVersionResult
import javax.inject.Inject

internal class KeysBackupAlgorithmFactory @Inject constructor() {

    fun create(keysVersion: KeysVersionResult): KeysBackupAlgorithm {
        return when (keysVersion.algorithm) {
            MXCRYPTO_ALGORITHM_CURVE_25519_BACKUP -> {
                KeysBackupCurve25519Algorithm(keysVersion)
            }
            MXCRYPTO_ALGORITHM_AES_256_BACKUP -> {
                throw IllegalStateException("AES_256 is not yet handled")
            }
            else -> {
                throw IllegalStateException("Unknown algorithm")
            }
        }
    }
}
