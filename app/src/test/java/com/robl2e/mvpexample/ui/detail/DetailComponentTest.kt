package com.robl2e.mvpexample.ui.detail

import android.view.ViewGroup
import com.robl2e.mvpexample.fakes.FakeDataRepository
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class DetailComponentTest {
    private lateinit var component: TestDetailComponent

    @Before
    fun setUp() {
        component = TestDetailComponent(mockk())
    }

    @Test
    fun testLoadFinished() {
        component.onCreate(mockk())
        component.onEvent(DetailContract.ViewEvent.ButtonClick)

        verify { component.presenter.loadData()}

        verify { component.view.render(any())} //TODO Get unit testing exact ViewState working
    }

}

class TestDetailComponent(container: ViewGroup) : DetailComponent(container) {
    override fun initView(container: ViewGroup): DetailContract.View {
        return mockk<DetailMvpViewImpl>(relaxed = true)
    }

    override fun initPresenter(): DetailContract.Presenter {
        return spyk(DetailPresenter(FakeDataRepository()))
    }
}