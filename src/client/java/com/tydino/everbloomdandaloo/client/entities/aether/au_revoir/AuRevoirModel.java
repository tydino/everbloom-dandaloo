package com.tydino.everbloomdandaloo.client.entities.aether.au_revoir;
// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.Identifier;

import static net.minecraft.client.model.geom.PartPose.offsetAndRotation;

public class AuRevoirModel extends EntityModel<AuRevoirRenderState> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart tailmid;
	private final ModelPart tailtip;
	private final ModelPart leftbigwing;
	private final ModelPart rightbigwing;
	private final ModelPart leftsmallwing;
	private final ModelPart rightsmallwing;
	private final ModelPart mouth;
	private final ModelPart eyelid;

	final KeyframeAnimation flap;
	final KeyframeAnimation blink;
	final KeyframeAnimation latch;


	public AuRevoirModel(ModelPart root) {
		super(root);
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.tail = this.body.getChild("tail");
		this.tailmid = this.tail.getChild("tailmid");
		this.tailtip = this.tailmid.getChild("tailtip");
		this.leftbigwing = this.body.getChild("leftbigwing");
		this.rightbigwing = this.body.getChild("rightbigwing");
		this.leftsmallwing = this.body.getChild("leftsmallwing");
		this.rightsmallwing = this.body.getChild("rightsmallwing");
		this.mouth = this.body.getChild("mouth");
		this.eyelid = this.body.getChild("eyelid");

		this.flap = AuRevoirAnimations.flapping.bake(root);
		this.blink = AuRevoirAnimations.blink.bake(root);
		this.latch = AuRevoirAnimations.latch.bake(root);
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition root = modelPartData.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 14).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(20, 22).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), offsetAndRotation(0.0F, -2.0F, 2.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition tailmid = tail.addOrReplaceChild("tailmid", CubeListBuilder.create().texOffs(22, 6).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), offsetAndRotation(0.0F, 1.0F, 4.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition tailtip = tailmid.addOrReplaceChild("tailtip", CubeListBuilder.create().texOffs(22, 6).addBox(0.0F, -2.0F, -0.5F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 1.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition leftbigwing = body.addOrReplaceChild("leftbigwing", CubeListBuilder.create().texOffs(0, 4).addBox(-8.0F, -2.0F, -1.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(5, 0).addBox(-12.0F, -2.0F, -1.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 0.0F, 0.0873F, -0.3927F, 0.3927F));

		PartDefinition rightbigwing = body.addOrReplaceChild("rightbigwing", CubeListBuilder.create().texOffs(28, 4).addBox(0.0F, -2.0F, -1.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(33, 0).addBox(8.0F, -2.0F, -1.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, 0.0F, 0.0873F, 0.3927F, -0.3927F));

		PartDefinition leftsmallwing = body.addOrReplaceChild("leftsmallwing", CubeListBuilder.create().texOffs(6, 12).addBox(-5.0F, 0.0F, -3.0F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(9, 9).addBox(-8.0F, 0.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, 2.0F, 0.0873F, 0.3927F, 0.2618F));

		PartDefinition rightsmallwing = body.addOrReplaceChild("rightsmallwing", CubeListBuilder.create().texOffs(30, 12).addBox(0.0F, 0.0F, -3.0F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(33, 9).addBox(5.0F, 0.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, 2.0F, -0.0873F, -0.3927F, -0.2618F));

		PartDefinition mouth = body.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 17).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -1.0F));

		PartDefinition eyelid = body.addOrReplaceChild("eyelid", CubeListBuilder.create().texOffs(0, 10).addBox(2.01F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 10).addBox(-2.01F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -2.0F));
		return LayerDefinition.create(modelData, 52, 27);
	}

	@Override
	public void setupAnim(AuRevoirRenderState state) {
		super.setupAnim(state);

		if(state.blinkAnimation.isStarted()){
			this.blink.apply(state.blinkAnimation, state.ageInTicks);
		}

		if(state.flappingAnimation.isStarted()){
			this.flap.apply(state.flappingAnimation, state.ageInTicks);
		}

		if(state.latchAnimation.isStarted()) {
			this.latch.apply(state.latchAnimation, state.ageInTicks);
		}
	}
}