/*
 * Copyright (c) 2021 New Vector Ltd
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

package im.vector.app.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import im.vector.app.core.platform.DebugReceiver
import im.vector.app.features.navigation.DebugNavigator

@InstallIn(SingletonComponent::class)
@Module
object DebugModule {

    @Provides
    fun providesDebugReceiver() = object : DebugReceiver {
        override fun register() {
            // no op
        }

        override fun unregister() {
            // no op
        }
    }

    @Provides
    fun providesDebugNavigator() = object : DebugNavigator {
        override fun openDebugMenu(context: Context) {
            // no op
        }
    }
}
