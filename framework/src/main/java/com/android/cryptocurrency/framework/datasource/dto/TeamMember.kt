package com.android.cryptocurrency.framework.datasource.dto

data class TeamMember(
    val id: String,
    val name: String,
    val position: String
)

fun TeamMember.toTeamMember(): com.android.cryptocurrency.domain.model.TeamMember {
    return com.android.cryptocurrency.domain.model.TeamMember(
        id = id,
        name = name,
        position = position,
    )
}