import org.junit.Test

import org.junit.Assert.*

class WallServicesTest {
    var posts = emptyArray<Post>()
    var idIndividual = 1
    val views1 = Views(
        count = 543
    )
    val reposts1 = Reposts(
        count = 54,
        userReposted = true
    )
    val likes1 = Likes(
        count = 12,
        userLikes = true,
        canLike = false,
        canPublish = false
    )
    val comment1 = Comments(
        count = 15,
        canPost = true,
        groupsCanPost = true,
        canClose = true,
        canOpen = false
    )
    val original = Post(
        id = 1,
        ownerId = 1,
        fromId = 21,
        createdBy = 22,
        date = 12,
        text = "Hello",
        replyOwnerId = 654,
        replyPostId = 980,
        friendsOnly = 98,
        comments = comment1,
        copyright = "Netology.ru",
        likes = likes1,
        reposts = reposts1,
        views = views1,
        post_type = "Post",
        signerId = 43,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = 1,
        markedAsAds = false,
        isFavorite = true,
        postponedId = 0
    )
    val original1 = Post(
        id = 2,
        ownerId = 1,
        fromId = 21,
        createdBy = 22,
        date = 12,
        text = "Hello",
        replyOwnerId = 654,
        replyPostId = 980,
        friendsOnly = 98,
        comments = comment1,
        copyright = "Netology.ru",
        likes = likes1,
        reposts = reposts1,
        views = views1,
        post_type = "Post",
        signerId = 43,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = 1,
        markedAsAds = false,
        isFavorite = true,
        postponedId = 0
    )

    @Test
    fun add() {
        posts += WallServices.add(original)
        val result = posts.last().id
        if (result != 0) {
            assertEquals(1, result)
        }
    }

    @Test
    fun updateCompleted() {
        posts += WallServices.add(original)
        posts += WallServices.add(original1)
        val result = WallServices.update(original)
        assertTrue(result)
    }

    @Test
    fun updateError() {
        posts += WallServices.add(original)
        val result = WallServices.update(original1)
        assertFalse(result)
    }
}